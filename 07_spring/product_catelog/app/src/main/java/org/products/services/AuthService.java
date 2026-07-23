package org.products.services;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.products.Dtos.TokenPair;
import org.products.Dtos.request.RequestDto;
import org.products.Dtos.response.ApiResponse;
import org.products.Dtos.response.DataAndTokensResponse;
import org.products.entities.RefreshToken;
import org.products.entities.User;
import org.products.enums.Role;
import org.products.exceptions.CustomException;
import org.products.repository.RefreshTokenRepository;
import org.products.repository.UserRepository;
import org.products.utils.JwtUtil;
import org.products.utils.RequestUtils;
import org.products.utils.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository UserRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;
    private final SecurityUtils securityUtils;


    public ApiResponse<?> registerUser(RequestDto user, HttpServletRequest request) {
        // Check if email already exists
        Optional<User> existingUser = UserRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new CustomException("Email is already taken", HttpStatus.CONFLICT);
        }

        // hashing the password
        String hashedPassword = securityUtils.encodePassword(user.getPassword());
        User newUser = User.builder()
                .fullName(user.getFullName())
                .email(user.getEmail())
                .password(hashedPassword)
                .role(Role.valueOf(user.getRole()))
                .isActive(true)
                .build();

        UserRepository.save(newUser);

        // generate tokens
        TokenPair tokenPair = jwtUtil.generateToken(newUser);

        String ipAddress = RequestUtils.getClientIpAddress(request);
        String userAgent = RequestUtils.getUserAgent(request);

        RefreshToken refreshToken = RefreshToken.builder()
                .userId(newUser.getId())
                .token(tokenPair.getRefreshToken())
                .expiresAt(tokenPair.getRefreshExpiredAt())
                .revoked(false)
                .ipAddress(ipAddress)
                .userAgent(userAgent)
                .build();

        refreshTokenRepository.save(refreshToken);
        DataAndTokensResponse dataAndTokensResponse = new DataAndTokensResponse(newUser, tokenPair);
        return ApiResponse.success(dataAndTokensResponse, "User register successfully");
    }
}
