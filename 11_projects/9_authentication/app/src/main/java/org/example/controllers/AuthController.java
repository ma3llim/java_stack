package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.dtos.LoginRequest;
import org.example.dtos.TokenResponse;
import org.example.dtos.UserDto;
import org.example.entities.User;
import org.example.repositories.UserRepository;
import org.example.security.JwtService;
import org.example.security.config.JwtProperties;
import org.example.services.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final JwtProperties jwtProperties;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticate(loginRequest);
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new BadCredentialsException("User Not Found By This Email Id " + loginRequest.getEmail()));
        if (!user.isEnabled()) {
            throw new DisabledException("User is disabled");
        }

        // generate token
        String accessToken = jwtService.generateAccessToken(user);
        TokenResponse tokenResponse = TokenResponse.builder()
                .accessToken(accessToken)
                .expiresIn(jwtProperties.getAccessTtlSeconds())
                .tokenType("accessToken")
                .userDto(modelMapper.map(user, UserDto.class)).build();

        return ResponseEntity.ok(tokenResponse);
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
