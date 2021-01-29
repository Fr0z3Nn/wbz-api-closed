package com.wbz.wbzapi.mapper.Impl;

import com.wbz.wbzapi.dto.AdminDTO;
import com.wbz.wbzapi.dto.RoleDTO;
import com.wbz.wbzapi.dto.UserDTO;
import com.wbz.wbzapi.entity.Role;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.mapper.AdminMapper;

import java.util.ArrayList;
import java.util.List;

public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminDTO toAdminDTO(User user) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(user.getId());
        adminDTO.setUsername(user.getUsername());
        adminDTO.setEmail(user.getEmail());
        List<RoleDTO> rolesDTO = new ArrayList<>();
        for(Role role : user.getRoles()){
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setName(role.getName());
            rolesDTO.add(roleDTO);
        }
        adminDTO.setStatus(user.getStatus().name());
        adminDTO.setRoles(rolesDTO);
        return adminDTO;
    }
}
