package com.iqmsoft.boot.jwt.service;

import java.util.List;

import com.iqmsoft.boot.jwt.model.User;

public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll ();
}
