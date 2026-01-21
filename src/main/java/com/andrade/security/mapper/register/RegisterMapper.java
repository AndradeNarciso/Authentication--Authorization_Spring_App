package com.andrade.security.mapper.register;

import org.springframework.stereotype.Component;

import com.andrade.security.domain.User;
import com.andrade.security.dto.register.UserRegisterResponse;

@Component
public class RegisterMapper {

    public UserRegisterResponse userToResponse(User user) {
        return UserRegisterResponse.builder().
                                    email(user.getEmail()).
                                    name(user.getName()).
                                    build();
    }
}
