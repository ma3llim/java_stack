package com.sameer.spring_security.controller;

import com.sameer.spring_security.model.User;
import com.sameer.spring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            return ResponseEntity.ok("Login Success");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials");
        }
    }
}
