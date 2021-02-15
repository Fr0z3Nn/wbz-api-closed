package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.dto.UserDTO;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.mapper.UserMapper;
import com.wbz.wbzapi.service.AuthorizationService;
import com.wbz.wbzapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
@Tag(name = "Админ контроллер", description = "API для работы со стороны администрации")
public class AdminController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthorizationService authorizationService;
    @GetMapping("users/{id}")
    @Operation(
            summary = "Поиск пользователя",
            description = "Позволяет найти пользователя. Отличительная особенность - отображается статус"
    )

    public ResponseEntity<UserDTO> getUserById(@RequestHeader HttpHeaders httpHeaders, @PathVariable(name = "id") Long id) {
        authorizationService.validateToken(httpHeaders);
        User user = userService.findById(id);
        UserDTO result = userMapper.toUserDTOFromAdminRequest(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
