package org.example.services;

import org.example.dtos.UserDto;

import java.util.Iterator;

public interface UserService {
    // Create User
    UserDto createUser(UserDto userDto);

    // Get User By Email
    UserDto getUserByEmail(String email);

    // Update a user
    UserDto updateUser(UserDto userDto, String userId);

    // delete user
    void deleteUser(String userId);

    // Get User By id
    UserDto getUserById(String userId);

    // Get all users
    Iterator<UserDto> getAllUsers();
}
