package com.andrade.security.dto.register;

import lombok.Builder;

@Builder
public record UserRegisterResponse(String name, String email) {

}
