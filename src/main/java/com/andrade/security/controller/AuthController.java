package com.andrade.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.security.dto.login.UserLoginRequest;
import com.andrade.security.dto.login.UserLoginResponse;
import com.andrade.security.service.LoginService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {


private final LoginService loginService;
    
    @PostMapping("/user/login")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest loginUserRequest){
        loginService.loginUser(loginUserRequest);
        return null;
    }
    
}
