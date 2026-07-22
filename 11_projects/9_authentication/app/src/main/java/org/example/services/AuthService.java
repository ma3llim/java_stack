package org.example.services;

import lombok.AllArgsConstructor;
import org.example.dtos.LoginRequest;
import org.example.dtos.TokenResponse;
import org.example.dtos.UserDto;
import org.example.entities.RefreshToken;
import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.example.security.JwtService;
import org.example.security.config.JwtProperties;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final JwtProperties jwtProperties;

    public UserDto registerUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userService.createUser(userDto);
    }

    public TokenResponse loginUser(LoginRequest loginRequest) {
        Authentication authentication = authenticate(loginRequest);
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new BadCredentialsException("User Not Found By This Email Id " + loginRequest.getEmail()));
        if (!user.isEnabled()) {
            throw new DisabledException("User is disabled");
        }

        // generate token
        String accessToken = jwtService.generateAccessToken(user);

        return TokenResponse.builder()
                .accessToken(accessToken)
                .expiresIn(jwtProperties.getAccessTtlSeconds())
                .tokenType("accessToken")
                .userDto(modelMapper.map(user, UserDto.class)).build();
    }

    private Authentication authenticate(LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
        return null;
    }

}
