package com.wbz.wbzapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wbz.wbzapi.entity.Role;
import com.wbz.wbzapi.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private List<RoleDTO> roles;

    public User toUser(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        return user;
    }

    public static UserDTO fromUser(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        List<RoleDTO> rolesDTO = new ArrayList<>();
        for(Role role : user.getRoles()){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setName(role.getName());
            rolesDTO.add(roleDTO);
        }
        userDto.setRoles(rolesDTO);
        return userDto;
    }
}
