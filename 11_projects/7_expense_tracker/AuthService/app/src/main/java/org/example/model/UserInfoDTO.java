package org.example.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import org.example.entities.UserInfo;
import org.example.entities.UserRole;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserInfoDTO extends UserInfo {
    private String userId;
    private String username;
    private String password;
    private Set<UserRole> roles;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
}