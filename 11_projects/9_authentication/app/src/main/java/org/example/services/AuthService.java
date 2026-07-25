package org.example.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dtos.LoginRequest;
import org.example.dtos.RefreshTokenRequest;
import org.example.dtos.TokenResponse;
import org.example.dtos.UserDto;
import org.example.entities.RefreshToken;
import org.example.entities.User;
import org.example.repositories.RefreshTokenRepository;
import org.example.repositories.UserRepository;
import org.example.security.CookieService;
import org.example.security.JwtService;
import org.example.security.config.JwtProperties;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final CookieService cookieService;

    public UserDto registerUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userService.createUser(userDto);
    }

    public TokenResponse loginUser(LoginRequest loginRequest, HttpServletResponse response) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new BadCredentialsException("User Not Found By This Email Id " + loginRequest.getEmail()));
        if (!user.isEnabled()) {
            throw new DisabledException("User is disabled");
        }

        // create response token object
        String jti = UUID.randomUUID().toString();
        var refreshTokenObj = RefreshToken.builder()
                .jti(jti)
                .user(user)
                .createdAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(jwtProperties.getRefreshTtlSeconds()))
                .revoked(false)
                .replacedByToken("")
                .build();

        // refresh token information save
        refreshTokenRepository.save(refreshTokenObj);

        // generate token access and refresh
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user, refreshTokenObj.getJti());

        // attach token to cookies
        cookieService.attachRefreshCookie(response, refreshToken, (int) jwtProperties.getRefreshTtlSeconds());
        cookieService.addNoStoreHeaders(response);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiresIn(jwtProperties.getAccessTtlSeconds())
                .tokenType("Bearer")
                .userDto(modelMapper.map(user, UserDto.class)).build();
    }

    public TokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest, HttpServletResponse response, HttpServletRequest request) {
        String refreshToken = getRefreshTokenFromRequest(refreshTokenRequest, request).orElseThrow(() -> new BadCredentialsException("Refresh Token is missing"));
        Jws<Claims> jwsParse = jwtService.parse(refreshToken);
        Claims ClaimsOfToken = jwsParse.getPayload();
        if (!jwtService.isRefreshToken(ClaimsOfToken)) {
            throw new BadCredentialsException("Invalid Refresh Token Type");
        }

        String jti = jwtService.getJwtId(refreshToken);
        UUID userId = jwtService.getUserId(refreshToken);
        RefreshToken storedRefreshToken = refreshTokenRepository.findByJti(jti).orElseThrow(() -> new BadCredentialsException("Invalid Refresh Token"));

        if (storedRefreshToken.isRevoked()) {
            throw new BadCredentialsException("Refresh token expired or revoked");
        }

        if (storedRefreshToken.getExpiresAt().isBefore(Instant.now())) {
            throw new BadCredentialsException("Refresh token expired");
        }

        if (!storedRefreshToken.getUser().getId().equals(userId)) {
            throw new BadCredentialsException("Refresh token does not belong to this user");
        }

        // refresh token rotate:
        storedRefreshToken.setRevoked(true);
        String newJti = UUID.randomUUID().toString();
        storedRefreshToken.setReplacedByToken(newJti);

        User user = storedRefreshToken.getUser();

        var newRefreshTokenDb = RefreshToken.builder()
                .jti(newJti)
                .user(user)
                .createdAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(jwtProperties.getRefreshTtlSeconds()))
                .revoked(false)
                .replacedByToken("")
                .build();

        refreshTokenRepository.save(newRefreshTokenDb);

        String newAccessToken = jwtService.generateAccessToken(user);
        String newRefreshToken = jwtService.generateRefreshToken(user, newJti);

        cookieService.attachRefreshCookie(response, newRefreshToken, (int) jwtProperties.getRefreshTtlSeconds());
        cookieService.addNoStoreHeaders(response);

        return TokenResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .expiresIn(jwtProperties.getAccessTtlSeconds())
                .userDto(modelMapper.map(user, UserDto.class))
                .tokenType("Bearer")
                .build();
    }

    public ResponseEntity<Object> logout(HttpServletResponse response, HttpServletRequest request) {
        getRefreshTokenFromRequest(null, request).ifPresent(token -> {
            Jws<Claims> jwsParse = jwtService.parse(token);
            Claims ClaimsOfToken = jwsParse.getPayload();
            try {
                if (jwtService.isRefreshToken(ClaimsOfToken)) {
                    String jti = jwtService.getJwtId(token);
                    refreshTokenRepository.findByJti(jti).ifPresent(
                            refreshToken -> {
                                refreshToken.setRevoked(true);
                                refreshTokenRepository.save(refreshToken);
                            }
                    );
                }
            } catch (JwtException ignored) {
            }
        });

        // remove cookies
        cookieService.clearRefreshCookie(response);
        cookieService.addNoStoreHeaders(response);
        SecurityContextHolder.clearContext();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private Optional<String> getRefreshTokenFromRequest(RefreshTokenRequest refreshTokenRequest, HttpServletRequest request) {
        // get token from cookie
        if (request.getCookies() != null) {
            Optional<String> fromCookie = Arrays.stream(
                            request.getCookies()
                    ).filter(cookie -> cookieService.getRefreshTokenCookieName().equals(cookie.getName()))
                    .map(Cookie::getValue)
                    .filter(v -> !v.isBlank())
                    .findFirst();

            if (fromCookie.isPresent()) {
                return fromCookie;
            }
        }
        // get token from body
        if (refreshTokenRequest != null && refreshTokenRequest.getRefreshToken() != null && !refreshTokenRequest.getRefreshToken().isBlank()) {
            return Optional.of(refreshTokenRequest.getRefreshToken());
        }
        return Optional.empty();
    }

    private Authentication authenticate(LoginRequest loginRequest) {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
