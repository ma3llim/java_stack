package com.sameer.auth_service.service;

import com.sameer.auth_service.dto.AuthResponse;
import com.sameer.auth_service.dto.LoginRequest;
import com.sameer.auth_service.dto.RegisterRequest;
import com.sameer.auth_service.entity.RefreshToken;
import com.sameer.auth_service.entity.User;
import com.sameer.auth_service.enums.Role;
import com.sameer.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    public void register(RegisterRequest request) {
        if (userRepository.existsByUsername(request.username())) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder().username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .enabled(true)
                .build();

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        String accessToken = jwtService.generateAccessToken(user);

        RefreshToken refreshToken = refreshTokenService.create(user);

        return new AuthResponse(accessToken, refreshToken.getToken(), "Bearer");
    }

    public AuthResponse refresh(String token) {
        RefreshToken refreshToken = refreshTokenService.validate(token);
        User user = refreshToken.getUser();

        String accessToken = jwtService.generateAccessToken(user);

        return new AuthResponse(accessToken, refreshToken.getToken(), "Bearer"
        );
    }

    public void logout(String token) {
        RefreshToken refreshToken = refreshTokenService.validate(token);
        refreshTokenService.revoke(refreshToken);
    }
}
