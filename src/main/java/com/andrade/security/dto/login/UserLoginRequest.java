package com.andrade.security.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Builder;

@Builder
public record UserLoginRequest(
        @NotBlank String password,
        @Email @NotBlank String email) {

}
