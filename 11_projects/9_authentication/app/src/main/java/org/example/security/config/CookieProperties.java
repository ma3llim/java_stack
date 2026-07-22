package org.example.security.config;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "security.cookie")
public class CookieProperties {
    private String name;
    private boolean secure;
    private boolean httpOnly;
    private String domain;
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
