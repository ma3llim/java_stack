package org.example.service;

import org.example.entities.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public User updatedUser(UUID userId, User user) {
        User userExisting = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));

        if (user.getName() != null && !user.getName().isBlank()) userExisting.setName(user.getName());
        if (user.getEmail() != null && !user.getEmail().isBlank()) userExisting.setEmail(user.getEmail());
        if (user.getPhone() != null && !user.getPhone().isBlank()) userExisting.setPhone(user.getPhone());
        if (user.getPassword() != null && !user.getPassword().isBlank()) userExisting.setPassword(user.getPassword());

        return userExisting;
    }

    public boolean deleteUser(UUID userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
