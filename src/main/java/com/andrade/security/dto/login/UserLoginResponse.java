package com.andrade.security.dto.login;

import lombok.Builder;

@Builder
public record UserLoginResponse(String token) {

}
