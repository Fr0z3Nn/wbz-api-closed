package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.entity.Item;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.service.Impl.ItemServiceImpl;
import com.wbz.wbzapi.service.Impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @RequestMapping("/api/register")
    public void saveUser(@RequestBody User user) {
        System.out.println(123);
        userService.save(user);
    }

    @PostMapping("/login_check")
    public User getById(@RequestBody Object user) {

        System.out.println(55555555);
        return userService.getById(1L);
    }
}
