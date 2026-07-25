package org.example.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.example.dtos.LoginRequest;
import org.example.dtos.RefreshTokenRequest;
import org.example.dtos.TokenResponse;
import org.example.dtos.UserDto;
import org.example.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginUser(loginRequest, response));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody(required = false) RefreshTokenRequest refreshTokenRequest, HttpServletResponse response, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.refreshToken(refreshTokenRequest, response, request));
    }

    @PostMapping("/logout")
    public ResponseEntity<ResponseEntity<Object>> logout(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.logout(response, request));
    }
}
