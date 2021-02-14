package com.wbz.wbzapi.service.Impl;

import com.wbz.wbzapi.service.AutheticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AutheticationService {

    private final AuthenticationManager authenticationManager;
    @Override
    public void authenticate(String login, String password) {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
    }
}
