package com.wbz.wbzapi.service;

import com.wbz.wbzapi.entity.User;

public interface UserService {
    User getById(Long id);
    void save(User user);
}
