package com.js.ms.todo.global.config.security.jwt;

import com.js.ms.todo.domain.member.domain.Role;
import com.js.ms.todo.global.config.exception.business.UnAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.auth0.jwt.interfaces.Claim;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

    /**
     * JWT 흐름
     * <p>
     * 1. 로그인 후 JWT 발급하기 (oauth2로그인 후 successhandler에서)
     * 2. API 요청시 JWT 함께 보내서, 해당 JWT의 유효성을 검증하는 과정 (필터에서)
     */


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getRequestURI().startsWith("/member/")) {
            chain.doFilter(req, res);
            return;
        }

        String token = req.getHeader("Authorization");
        if (ObjectUtils.isEmpty(token)) {
            throw new UnAuthenticationException();
        }

        // 인증을 위한 토큰 값(id, email, role)
        UsernamePasswordAuthenticationToken authentication = getAuthentication(token);
        // == @AuthenticationPrincipal
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);


    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        Map<String, Claim> claimMap = JWTGenerator.decode(token); // payload 정보를 담아온다.

        Long id = Long.parseLong(claimMap.get("id").asString());
        String email = claimMap.get("email").asString();
        String role = claimMap.get("role").asString();
        GrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);

        return new UsernamePasswordAuthenticationToken(id, email, Collections.singleton(simpleGrantedAuthority)); // spring security 권한 객체
    }
}