package com.andrade.security.mapper.login;

import com.andrade.security.dto.login.UserLoginResponse;

public class LoginMapper {

    public UserLoginResponse tokenToLoginResposne(String token) {
        return UserLoginResponse.builder().token(token).build();
    }
}
