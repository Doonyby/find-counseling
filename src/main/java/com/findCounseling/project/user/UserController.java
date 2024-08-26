package com.findCounseling.project.user;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {

        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody final User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody final User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
