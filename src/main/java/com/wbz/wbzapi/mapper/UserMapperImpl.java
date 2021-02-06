package com.wbz.wbzapi.mapper;

import com.wbz.wbzapi.dto.RoleDTO;
import com.wbz.wbzapi.dto.UserDTO;
import com.wbz.wbzapi.entity.Role;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User user) {
        return getUserDTO(user, "USER");
    }

    @Override
    public UserDTO toUserDTOFromAdminRequest(User user) {
        return getUserDTO(user, "ADMIN");
    }

    private UserDTO getUserDTO(User user, String userRole) {
        UserDTO userDto = UserDTO.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .id(user.getId())
                .build();
        List<RoleDTO> rolesDTO = new ArrayList<>();
        for (Role role : user.getRoles()) {
            rolesDTO.add(
                    RoleDTO.builder()
                            .name(role.getName())
                            .build());
        }
        if (userRole.equals("ADMIN")) {
            userDto.setStatus(user.getStatus());
        }
        userDto.setRoles(rolesDTO);
        return userDto;
    }
}
