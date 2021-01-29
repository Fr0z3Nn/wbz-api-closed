package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.dto.UserDTO;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.mapper.UserMapper;
import com.wbz.wbzapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users/")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDTO result = userMapper.toUserDTO(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
