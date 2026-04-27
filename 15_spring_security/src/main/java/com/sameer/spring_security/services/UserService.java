package com.sameer.spring_security.services;

import com.sameer.spring_security.model.User;
import com.sameer.spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User saveUser(User user){
        return userRepo.save(user);
    }
}
