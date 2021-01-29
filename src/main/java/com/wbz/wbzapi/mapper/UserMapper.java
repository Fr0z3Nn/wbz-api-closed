package com.wbz.wbzapi.mapper;


import com.wbz.wbzapi.dto.UserDTO;
import com.wbz.wbzapi.entity.User;

public interface UserMapper {
    UserDTO toUserDTO(User user);
    UserDTO toUserDTOFromAdminRequest(User user);
}
