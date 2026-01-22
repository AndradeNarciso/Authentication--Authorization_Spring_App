package com.andrade.security.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.andrade.security.domain.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class TokenConfig {

    @Value("${secret.token}")
    private String secretToken;

    public String token(User user) {
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId().toString())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plusSeconds(60 * 15)) // 15 min
                .sign(Algorithm.HMAC256(secretToken));
    }
}
