package org.example.dtos;

import lombok.*;
import org.example.entities.Address;
import org.example.entities.Role;
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
    private String email;
    private String name;
    private String password;
    private String image;
    private boolean isLogin;
    private Instant lastLoginAt;
    private String gender;
    private AddressDto address;
    private Provider provider = Provider.INTERNAL;
    private Set<RoleDto> roles = new HashSet<>();
    private Instant createdAt;
    private Instant updatedAt;
}
