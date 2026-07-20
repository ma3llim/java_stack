package org.example.services;

import org.example.dtos.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    // Create User
    UserDto createUser(UserDto userDto);

    // Get User By Email
    UserDto getUserByEmail(String email);

    // Update a user
    UserDto updateUser(UserDto userDto, UUID userId);

    // delete user
    String deleteUser(UUID userId);

    // Get User By id
    UserDto getUserById(UUID userId);

    // Get all users
    List<UserDto> getAllUsers();
}
