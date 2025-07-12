package com.salaon.userservice.service;

import com.salaon.userservice.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User updateUser(User user, Long userId);

    void deleteUser(Long id);

    List<User> getUsers();

    User getUserById(Long id);
}
