package com.wbz.wbzapi.service;

import com.wbz.wbzapi.entity.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String login);

    User findById(Long id);

    void delete(Long id);
}
