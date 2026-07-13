package org.example.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.entities.UserInfo;
import org.example.model.UserInfoDTO;
import org.example.repository.UserRepository;
import org.example.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.UUID;

@Component
@AllArgsConstructor
@Data
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could Not Found User..!!");
        }
        return new CustomUserDetails(user);
    }

    public UserInfo checkIfUserAlreadyExsist(UserInfoDTO userInfoDTO) {
        return userRepository.findByUsername(userInfoDTO.getUsername());
    }

    public Boolean signUpUser(UserInfoDTO userInfoDTO) {
        ValidationUtils.validateUser(userInfoDTO.getEmail(), userInfoDTO.getPassword());
        userInfoDTO.setPassword(passwordEncoder.encode(userInfoDTO.getPassword()));
        if (Objects.nonNull(checkIfUserAlreadyExsist(userInfoDTO))) {
            return false;
        }
        String userId = UUID.randomUUID().toString();
        userRepository.save(new UserInfo(userId, userInfoDTO.getUsername(), userInfoDTO.getPassword(), new HashSet<>()));
        return true;
    }
}
