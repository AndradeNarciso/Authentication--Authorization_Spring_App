package com.andrade.security.config;

import lombok.Builder;

@Builder
public record  JWTUserData(String userId, String email) {
    
}
