package com.andrade.security.mapper.login;

import org.springframework.stereotype.Component;

import com.andrade.security.dto.login.UserLoginResponse;

@Component
public class LoginMapper {

    public UserLoginResponse tokenToLoginResposne(String token) {
        return UserLoginResponse.builder().token(token).build();
    }
}
