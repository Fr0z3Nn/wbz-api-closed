package com.wbz.wbzapi.service.Impl;

import com.wbz.wbzapi.handler.exception.JwtAuthenticationException;
import com.wbz.wbzapi.security.jwt.JwtTokenProvider;
import com.wbz.wbzapi.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpHeaders;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements AuthorizationService {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void validateToken(HttpHeaders httpHeaders) {
        List<String> token = httpHeaders.get("AUTHORISATION_TOKEN");
        if (token.isEmpty() || !jwtTokenProvider.validateToken(token.get(0)))
            throw new JwtAuthenticationException("Нет прав на доступ");
    }
}
