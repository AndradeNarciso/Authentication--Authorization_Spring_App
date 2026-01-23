package com.andrade.security.config;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.andrade.security.domain.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
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

    public Optional<JWTUserData> validateToken(String token) {
        try {
            DecodedJWT decode = JWT.require(Algorithm.HMAC256(secretToken)).build().verify(token);
            return Optional.of(
                    JWTUserData.builder()
                            .userId(decode.getClaim("userId").asString())
                            .email(decode.getSubject())
                            .build());
        } catch (JWTVerificationException e) {
            log.info("Can not  decode the token, error: {}", e.getMessage());
            return Optional.empty();
        }

    }
}
