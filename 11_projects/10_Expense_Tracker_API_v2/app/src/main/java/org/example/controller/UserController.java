package org.example.controller;

import jakarta.validation.Valid;
import org.example.Dto.request.UserRequestDto;
import org.example.Dto.response.UserResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {
    @PostMapping
    public UserResponseDto createUser(@Valid @RequestBody UserRequestDto userRequestDto){
    }
}
