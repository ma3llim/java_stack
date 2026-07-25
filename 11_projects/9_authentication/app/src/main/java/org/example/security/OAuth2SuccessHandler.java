package org.example.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entities.RefreshToken;
import org.example.entities.User;
import org.example.enums.Provider;
import org.example.repositories.RefreshTokenRepository;
import org.example.repositories.UserRepository;
import org.example.security.config.JwtProperties;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

@Component
@Slf4j
@AllArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final CookieService cookieService;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtService jwtService;

    /**
     * Called when a user has been successfully authenticated.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     *                       the authentication process.
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        // Identify User
        String registrationId = "unknown";
        if (authentication instanceof OAuth2AuthenticationToken authenticationToken) {
            registrationId = authenticationToken.getAuthorizedClientRegistrationId();
        }
        User user = null;
        switch (registrationId) {
            case "google":
                String email = oAuth2User.getAttributes().getOrDefault("email", "").toString();
                String name = oAuth2User.getAttributes().getOrDefault("name", "").toString();
                String pictureUrl = oAuth2User.getAttributes().getOrDefault("picture", "").toString();

                // checking user is there or not
                userRepository.findByEmail(email).ifPresent(user1 -> {
                    throw new BadCredentialsException("Email is Already existed");
                });

                user = User.builder()
                        .email(email)
                        .name(name)
                        .image(pictureUrl)
                        .provider(Provider.GOOGLE)
                        .build();

                userRepository.save(user);
        }

        // refresh Token
        String jti = UUID.randomUUID().toString();
        Instant now = Instant.now();
        RefreshToken refreshTokenDb = RefreshToken.builder()
                .jti(jti)
                .user(user)
                .revoked(false)
                .createdAt(now)
                .expiresAt(now.plusSeconds(jwtProperties.getRefreshTtlSeconds()))
                .replacedByToken("")
                .build();
        refreshTokenRepository.save(refreshTokenDb);

        // Generate Token
        String accessToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user, refreshTokenDb.getJti());

        cookieService.attachRefreshCookie(response, refreshToken, (int) jwtProperties.getRefreshTtlSeconds());
        response.getWriter().write("Login Success");
    }
}
