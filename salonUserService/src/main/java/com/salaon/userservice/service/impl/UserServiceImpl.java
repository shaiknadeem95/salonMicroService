package com.salaon.userservice.service.impl;

import com.salaon.userservice.entity.User;
import com.salaon.userservice.exception.UserException;
import com.salaon.userservice.repository.UserRepository;
import com.salaon.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long userId) {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserException("User not found");
        }
        user.setId(userId);
        user.setCreatedAt(userOptional.get().getCreatedAt());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> userOptional=userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserException("User not found");
        }
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional=userRepository.findById(id);
        return userOptional.orElseThrow(()->new UserException("User not found"));
    }
}
