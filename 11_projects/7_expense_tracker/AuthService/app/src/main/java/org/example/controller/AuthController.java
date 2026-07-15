package org.example.controller;

import org.example.entities.RefreshToken;
import org.example.model.UserInfoDTO;
import org.example.model.response.JwtResponse;
import org.example.services.JwtService;
import org.example.services.RefreshTokenService;
import org.example.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RefreshTokenService refreshTokenService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PostMapping("auth/v1/signup")
    public ResponseEntity Signup(@RequestBody UserInfoDTO userInfo) {
        try {
            Boolean isSignUpedUser = userDetailsService.signUpUser(userInfo);
            if (Boolean.FALSE.equals(isSignUpedUser)) {
                return new ResponseEntity<>("Already Exist", HttpStatus.BAD_REQUEST);
            }
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(userInfo.getUsername());
            String jwtToken = jwtService.GenerateToken(userInfo.getUsername());
            return new ResponseEntity<>(JwtResponse.builder().accessToken(jwtToken).token(refreshToken.getToken()).build(), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Exception in User Services", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
