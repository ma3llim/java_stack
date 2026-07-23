package org.products.utils;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.products.config.properties.JwtProperties;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    private final JwtProperties jwtProperties;

    public void generateToken(String username, String role) {
        Instant now = Instant.now();
    }

    public void validateToken() {

    }

    public String extractUsername() {
        return "";
    }
}
