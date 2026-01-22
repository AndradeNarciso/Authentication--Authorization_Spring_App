package com.andrade.security.service;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.andrade.security.config.TokenConfig;
import com.andrade.security.domain.User;
import com.andrade.security.dto.login.UserLoginRequest;
import com.andrade.security.dto.login.UserLoginResponse;
import com.andrade.security.mapper.login.LoginMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManagerLogin;
    private final TokenConfig generatetoken;
    private final LoginMapper loginMapper;

    public UserLoginResponse loginUser(UserLoginRequest user) {
        UsernamePasswordAuthenticationToken userAuthenticated = new UsernamePasswordAuthenticationToken(user.email(),
                user.password());
        Authentication auht = authenticationManagerLogin.authenticate(userAuthenticated);
        User userAuth = (User) auht.getPrincipal();
        return loginMapper.tokenToLoginResposne(generatetoken.token(userAuth));
    }
}
