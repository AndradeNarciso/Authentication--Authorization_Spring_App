package com.andrade.security.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenConfig tokenConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");
        if ((!authorization.isEmpty()) && authorization.startsWith("Bearer ")) {
            String headerToken = authorization.substring("Bearer ".length());
            Optional<JWTUserData> tokenData = tokenConfig.validateToken(headerToken);

            if (!tokenData.isPresent()) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            JWTUserData userData = tokenData.get();
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userData, null,
                    new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(auth);
            filterChain.doFilter(request, response);
        } else {
            filterChain.doFilter(request, response);
        }

    }

}
