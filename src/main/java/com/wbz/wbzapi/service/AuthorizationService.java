package com.wbz.wbzapi.service;

import org.springframework.http.HttpHeaders;
import java.util.List;

public interface AuthorizationService {
    void validateToken(HttpHeaders httpHeaders);
}
