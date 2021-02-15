package com.wbz.wbzapi.handler;

import com.wbz.wbzapi.handler.exception.ItemNotFoundException;
import com.wbz.wbzapi.handler.exception.JwtAuthenticationException;
import com.wbz.wbzapi.handler.exception.UserNotFoundException;
import com.wbz.wbzapi.handler.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public GlobalExceptionHandler() {
        super();
    }

    @ExceptionHandler({UserNotFoundException.class,
            ItemNotFoundException.class})
    public ResponseEntity<Response> handleException(Exception e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    //эксепшн проверки логин - пароль
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Response> handleException(BadCredentialsException e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    public ResponseEntity<Response> handleException(JwtAuthenticationException e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
