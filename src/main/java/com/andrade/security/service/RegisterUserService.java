package com.andrade.security.service;

import org.springframework.stereotype.Service;

import com.andrade.security.domain.User;
import com.andrade.security.dto.register.UserRegisterRequest;
import com.andrade.security.dto.register.UserRegisterResponse;
import com.andrade.security.mapper.register.RegisterMapper;
import com.andrade.security.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegisterUserService {

    private final UserRepository repository;
    private final RegisterMapper mapper;

    public UserRegisterResponse saveUser(UserRegisterRequest userRequest) {
        User user = User.builder().password(userRequest.password()).name(userRequest.name()).email(userRequest.email())
                .build();
        repository.save(user);
        return (mapper.userToResponse(user));
    }
}
