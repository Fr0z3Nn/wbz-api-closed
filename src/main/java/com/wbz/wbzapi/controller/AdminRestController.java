package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.dto.UserDTO;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.mapper.UserMapper;
import com.wbz.wbzapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
@Tag(name = "Админ контроллер", description = "API для работы со стороны администрации")
public class AdminRestController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("users/{id}")
    @Operation(
            summary = "Поиск пользователя",
            description = "Позволяет найти пользователя. Отличительная особенность - отображается статус"
    )
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);
        UserDTO result = userMapper.toUserDTOFromAdminRequest(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
