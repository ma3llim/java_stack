package org.example.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Auth Application",
                description = "Generic auth application that can be used with any application",
                contact = @Contact(
                        name = "Sameer",
                        email = "mohdsameer68257@gmail.com"
                ),
                version = "1.0"
        ),
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)

@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        description = "JWT authentication"
)
public class APIDocConfig {
    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder().group("Authentication").pathsToMatch("/api/v1/auth/**").build();
    }

    @Bean
    public GroupedOpenApi usersApi() {
        return GroupedOpenApi.builder().group("Users").pathsToMatch("/api/v1/users/**").build();
    }
}
