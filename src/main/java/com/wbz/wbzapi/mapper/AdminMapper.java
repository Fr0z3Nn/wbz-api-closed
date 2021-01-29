package com.wbz.wbzapi.mapper;

import com.wbz.wbzapi.dto.AdminDTO;
import com.wbz.wbzapi.entity.User;

public interface AdminMapper {
    AdminDTO toAdminDTO(User user);
}
