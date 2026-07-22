package org.example.security.config;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    @NotBlank(message = "JWT secret must not be blank")
    @Size(min = 32, message = "JWT secret must be at least 32 characters long")
    private String secret;

    @NotBlank(message = "JWT issuer must not be blank")
    private String issuer;

    @Min(value = 60, message = "Access token TTL must be at least 60 seconds")
    private long accessTtlSeconds;

    @Min(value = 300, message = "Refresh token TTL must be at least 300 seconds")
    private long refreshTtlSeconds;

    @Valid
    private Cookie cookie = new Cookie();

    @Getter
    @Setter
    public static class Cookie {

        private boolean secure;

        private boolean httpOnly;

        @NotBlank(message = "SameSite policy must not be blank")
        @Pattern(
                regexp = "Strict|Lax|None",
                message = "SameSite must be one of: Strict, Lax, None"
        )
        private String sameSite;

        @AssertTrue(message = "SameSite=None requires Secure=true")
        public boolean isSameSiteConfigurationValid() {
            return !"None".equalsIgnoreCase(sameSite) || secure;
        }
    }
}