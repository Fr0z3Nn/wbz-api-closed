package com.wbz.wbzapi.service;

import java.util.List;

public interface AuthorizationService {
    void validateToken(List<String> token);
}
