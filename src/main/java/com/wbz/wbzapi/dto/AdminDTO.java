package com.wbz.wbzapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
}
