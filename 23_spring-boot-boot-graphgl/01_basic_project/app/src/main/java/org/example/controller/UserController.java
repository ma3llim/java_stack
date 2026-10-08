package org.example.controller;

import org.example.entities.User;
import org.example.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MutationMapping
    public User createUser(
            @Argument String name,
            @Argument String phone,
            @Argument String email,
            @Argument String password) {

        User user = User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)
                .build();

        return userService.createUser(user);
    }

    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument UUID userId) {
        return userService.getUser(userId);
    }

    @MutationMapping
    public User updateUser(
            @Argument UUID userId,
            @Argument String name,
            @Argument String phone,
            @Argument String email,
            @Argument String password) {

        User user = User.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .password(password)
                .build();
        return userService.updatedUser(userId, user);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument UUID userId) {
        return userService.deleteUser(userId);
    }
}
