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
public class UserInfoDTO extends UserInfo {
    private String username;
    private String lastName;
    private String email;
    private Long phoneNumber;

    public UserInfoDTO(String userId, String username, String password, Set<UserRole> roles) {
        super(userId, username, password, roles);
    }
}
