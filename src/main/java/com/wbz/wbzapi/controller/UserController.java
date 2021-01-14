package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.service.Impl.ItemServiceImpl;
import com.wbz.wbzapi.service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping(
            value = "/api/register")
    public void saveUser(@RequestBody User user) {
        userService.save(user);
    }

    @PostMapping(
            value = "/api/login_check")
    public User getById(@RequestBody Long id) {
        return userService.getById(id);
    }
}
