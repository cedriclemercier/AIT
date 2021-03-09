package com.example.LAB2.service;

import com.example.LAB2.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
