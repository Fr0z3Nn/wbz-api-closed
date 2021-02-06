package com.wbz.wbzapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wbz.wbzapi.entity.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Status status;
    private List<RoleDTO> roles;
}
