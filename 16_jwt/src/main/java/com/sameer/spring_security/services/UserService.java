package com.sameer.spring_security.services;

import com.sameer.spring_security.model.User;
import com.sameer.spring_security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder encoder;

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
