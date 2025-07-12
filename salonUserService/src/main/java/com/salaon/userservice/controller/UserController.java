package com.salaon.userservice.controller;

import com.salaon.userservice.entity.User;
import com.salaon.userservice.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserRepository userRepository;

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable("id") Long id)
    {
        Optional<User> userOptional=userRepository.findById(id);
        return userOptional.orElseThrow(()->new RuntimeException("User not found"));
    }

    @DeleteMapping("/api/users/{id}")
    public String deleteUserById(@PathVariable("id") Long userId) {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
        return "User deleted";
    }

    @PutMapping("/api/users/{id}")
    public User updateUserById(@PathVariable("id") Long userId, @RequestBody User user) {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        user.setId(userId);
        user.setCreatedAt(userOptional.get().getCreatedAt());
        return userRepository.save(user);
    }

    @PostMapping("/api/users")
    public User createUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
