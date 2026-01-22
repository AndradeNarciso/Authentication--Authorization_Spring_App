package com.andrade.security.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.andrade.security.dto.login.UserLoginRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManagerLogin;

    public void loginUser(UserLoginRequest user) {
        UsernamePasswordAuthenticationToken userAuthenticated = new UsernamePasswordAuthenticationToken(user.email(),
                user.password());
                Authentication auht= authenticationManagerLogin.authenticate(userAuthenticated);
    }
}
