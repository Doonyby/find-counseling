package com.findCounseling.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUserById(String id) {
        User user = userRepository.findById(id).orElse(null);
        System.out.println(user);
        return user;
    }

    public User createUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        if (!validateUser(user)) throw new IllegalArgumentException("Invalid user");
        System.out.println("User created: " + user);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if (!validateUser(user)) throw new IllegalArgumentException("Invalid user");
        System.out.println("User updated: " + user);
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Boolean validateUser(User user) {
        return !user.getUsername().isEmpty() && !user.getPassword().isEmpty() && !user.getEmail().isEmpty() && !user.getRole().isEmpty() && user.getId() != null;
    }
}
