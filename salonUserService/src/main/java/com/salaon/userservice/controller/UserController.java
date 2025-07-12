package com.salaon.userservice.controller;

import com.salaon.userservice.entity.User;
import com.salaon.userservice.exception.UserException;
import com.salaon.userservice.repository.UserRepository;
import com.salaon.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id)
    {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted");
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable("id") Long userId, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user,userId), HttpStatus.OK);
    }

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>( userService.getUsers(),HttpStatus.OK);
    }
}
