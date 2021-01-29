package com.wbz.wbzapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wbz.wbzapi.entity.Status;
import com.wbz.wbzapi.entity.User;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminDTO {
    private Long id;
    private String username;
    private String email;
    private String status;
    private List<RoleDTO> roles;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setStatus(Status.valueOf(status));
        return user;
    }

    public static AdminDTO fromUser(User user) {
        AdminDTO adminDto = new AdminDTO();
        adminDto.setId(user.getId());
        adminDto.setUsername(user.getUsername());
        adminDto.setEmail(user.getEmail());
        adminDto.setStatus(user.getStatus().name());
        return adminDto;
    }
}
