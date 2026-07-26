package org.example.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.config.AppConstants;
import org.example.dtos.GithubEmailResponse;
import org.example.entities.RefreshToken;
import org.example.entities.Role;
import org.example.entities.User;
import org.example.enums.Provider;
import org.example.repositories.RefreshTokenRepository;
import org.example.repositories.RoleRepository;
import org.example.repositories.UserRepository;
import org.example.security.config.JwtProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserRepository userRepository;
    private final CookieService cookieService;
    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
    @Value("${app.auth.frontend.success-redirectUrl}")
    private String successRedirectUrl;

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
                String email = oAuth2User.getAttribute("email");
                String name = oAuth2User.getAttribute("name");
                String pictureUrl = oAuth2User.getAttribute("picture");

                if (email == null || email.isBlank()) {
                    throw new BadCredentialsException("Email not provided by Google");
                }

                user = userRepository.findByEmail(email)
                        .orElseGet(() -> {
                            User newUser = User.builder()
                                    .email(email)
                                    .name(name)
                                    .image(pictureUrl)
                                    .provider(Provider.GOOGLE)
                                    .build();

                            // assigning roles
                            Role role = roleRepository.findByName(AppConstants.USER_ROLE).orElse(null);
                            newUser.getRoles().add(role);
                            return userRepository.save(newUser);
                        });
                break;


            case "github":
                OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
                OAuth2AuthorizedClient client = oAuth2AuthorizedClientService.loadAuthorizedClient(
                        oauthToken.getAuthorizedClientRegistrationId(),
                        oauthToken.getName()
                );

                String githubAccessToken = client.getAccessToken().getTokenValue();
                String githubEmail = getGithubEmail(githubAccessToken);
                String githubName = oAuth2User.getAttribute("name");
                String githubAvatar = oAuth2User.getAttribute("avatar_url");


                if (githubEmail == null || githubEmail.isBlank()) {
                    throw new BadCredentialsException("Email not provided by GitHub");
                }

                user = userRepository.findByEmail(githubEmail)
                        .orElseGet(() -> {
                            User newUser = User.builder()
                                    .email(githubEmail)
                                    .name(githubName)
                                    .image(githubAvatar)
                                    .provider(Provider.GITHUB)
                                    .build();

                            // assigning roles
                            Role role = roleRepository.findByName(AppConstants.USER_ROLE).orElse(null);
                            newUser.getRoles().add(role);
                            return userRepository.save(newUser);
                        });
                break;

            default:
                throw new BadCredentialsException("Unsupported OAuth provider: " + registrationId);
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

        response.sendRedirect(successRedirectUrl);
    }

    private String getGithubEmail(String accessToken) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<List<GithubEmailResponse>> response =
                restTemplate.exchange("https://api.github.com/user/emails",
                        HttpMethod.GET, entity,
                        new ParameterizedTypeReference<List<GithubEmailResponse>>() {
                        }
                );

        return response.getBody()
                .stream()
                .filter(GithubEmailResponse::isPrimary)
                .filter(GithubEmailResponse::isVerified)
                .map(GithubEmailResponse::getEmail)
                .findFirst()
                .orElse(null);
    }
}
