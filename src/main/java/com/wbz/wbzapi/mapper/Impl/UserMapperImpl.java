package com.wbz.wbzapi.mapper.Impl;

import com.wbz.wbzapi.dto.RoleDTO;
import com.wbz.wbzapi.dto.UserDTO;
import com.wbz.wbzapi.entity.Role;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.mapper.UserMapper;
import com.wbz.wbzapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User user) {
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
