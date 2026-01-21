package com.andrade.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.security.dto.register.UserRegisterRequest;
import com.andrade.security.dto.register.UserRegisterResponse;
import com.andrade.security.service.RegisterUserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/register")
@RestController
@AllArgsConstructor
public class RegisterUserController {

    private final RegisterUserService registerService;

    @PostMapping("/users")
    public ResponseEntity<UserRegisterResponse> registerUser(@Valid @RequestBody UserRegisterRequest user) {
        return ResponseEntity.status(200).body(registerService.saveUser(user));
    }
}
