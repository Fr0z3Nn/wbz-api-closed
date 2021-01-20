package com.wbz.wbzapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wbz.wbzapi.entity.Status;
import com.wbz.wbzapi.entity.User;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String email;
    private String status;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminUserDto fromUser(User user){
        AdminUserDto userDto = new AdminUserDto();
        userDto.setId(userDto.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setStatus(user.getStatus().name());
        return userDto;
    }
}
