package com.andrade.security.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequest(
        @NotBlank String name,
        @NotBlank String email,
        @Email @NotBlank String password) {

}
