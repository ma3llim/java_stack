package com.sameer.spring_security.controller;

import com.sameer.spring_security.model.User;
import com.sameer.spring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }
}
