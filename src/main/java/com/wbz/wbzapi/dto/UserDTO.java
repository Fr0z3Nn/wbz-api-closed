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
}
