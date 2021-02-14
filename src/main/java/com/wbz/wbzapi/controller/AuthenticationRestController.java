package com.wbz.wbzapi.controller;

import com.wbz.wbzapi.dto.AuthenticationRequestDTO;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.security.jwt.JwtTokenProvider;
import com.wbz.wbzapi.service.AutheticationService;
import com.wbz.wbzapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
@Tag(name = "Контроллер аутентификации", description = "Позволяет проводить аутентификацию пользователя")
public class AuthenticationRestController {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final AutheticationService autheticationService;

    @PostMapping("/login")
    @Operation(
            summary = "Логин пользователя",
            description = "Позволяет проводить аутентификацию пользователя. Ответ - токен JWT"
    )
    public ResponseEntity<String> login(@RequestBody AuthenticationRequestDTO requestDTO) {
        String username = requestDTO.getUsername();
        String password = requestDTO.getPassword();
        autheticationService.authenticate(username, password);
        User user = userService.findByUsername(username);
        String token = jwtTokenProvider.createToken(username, user.getRoles());
        return ResponseEntity.ok(token);
    }
}
