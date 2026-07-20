package org.example.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.enums.Provider;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private UUID id;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$",
            message = "Password must contain at least one digit, one lowercase, one uppercase, one special character, and no whitespace"
    )
    private String password;

    private String image;
    private boolean isLogin;
    private Instant lastLoginAt;

    @Pattern(regexp = "^(MALE|FEMALE|OTHER)?$", message = "Gender must be MALE, FEMALE, or OTHER")
    private String gender;
    @Builder.Default
    private Provider provider = Provider.INTERNAL;
    @Builder.Default
    private Set<RoleDto> roles = new HashSet<>();
    private Instant createdAt;
    private Instant updatedAt;
}
