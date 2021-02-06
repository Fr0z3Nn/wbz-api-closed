package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/auth/")
public class RegistrationController {
    @RequestMapping("register")
    public ResponseEntity editItem(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok("suc");
    }
}