package com.example.midterm.service;

import com.example.midterm.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    List<User> findAll();
}
