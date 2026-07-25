package org.example.security;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.security.config.CookieProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CookieService {
    private final CookieProperties cookieProperties;

    // created method to attach cookie to response;
    public void attachRefreshCookie(HttpServletResponse response, String value, int maxAge) {
        var responseCookieBuilder = ResponseCookie.from(cookieProperties.getName(), value)
                .httpOnly(cookieProperties.isHttpOnly())
                .secure(cookieProperties.isSecure())
                .path("/")
                .maxAge(maxAge)
                .sameSite(cookieProperties.getSameSite());

        if (cookieProperties.getDomain() != null && !cookieProperties.getDomain().isBlank()) {
            responseCookieBuilder.domain(cookieProperties.getDomain());
        }
        ResponseCookie responseCookie = responseCookieBuilder.build();

        response.addHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
    }

    // Clear Refresh Cookie
    public void clearRefreshCookie(HttpServletResponse response) {
        var builder = ResponseCookie.from(cookieProperties.getName(), "")
                .httpOnly(cookieProperties.isHttpOnly())
                .secure(cookieProperties.isSecure())
                .path("/")
                .maxAge(0)
                .sameSite(cookieProperties.getSameSite());

        if (cookieProperties.getDomain() != null && !cookieProperties.getDomain().isBlank()) {
            builder.domain(cookieProperties.getDomain());
        }
        ResponseCookie responseCookie = builder.build();

        response.addHeader(HttpHeaders.SET_COOKIE, responseCookie.toString());
    }

    // No Cache Header
    public void addNoStoreHeaders(HttpServletResponse response) {
        response.setHeader(HttpHeaders.CACHE_CONTROL, "no-store");
        response.setHeader("Pragma", "no-cache");
    }

    public String getRefreshTokenCookieName() {
        return cookieProperties.getName();
    }
}
