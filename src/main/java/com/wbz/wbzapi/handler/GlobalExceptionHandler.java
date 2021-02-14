package com.wbz.wbzapi.handler;

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

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Response> handleException(UserNotFoundException e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Response> handleException(BadCredentialsException e) {
        return new ResponseEntity<>(new Response(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
