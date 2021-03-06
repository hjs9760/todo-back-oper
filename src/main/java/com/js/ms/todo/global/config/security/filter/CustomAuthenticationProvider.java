package com.js.ms.todo.global.config.security.filter;


import com.js.ms.todo.domain.member.domain.UserDetailsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * 화면에서 입력한 로그인 정보와 DB에서 가져온 사용자의 정보를 비교해주는 인터페이스
 *
 * 해당 인터페이스에 오버라이드되는 authenticate() 메서드는 화면에서 사용자가 입력한 로그인 정보를 담고 있는 Authentication 객체를 가지고 있다.
 * DB에서 사용자의 정보를 가져오는 건 UserDetailsService 인터페이스에서 loadUserByUsername() 메서드로 구현
 * 따라서 authenticate() 메서드에서 loadUserByUsernmae() 메서드를 이용해 DB에서 사용자 정보를 가져와서 Authentication 객체에서 화면에서 가져온 로그인 정보와 비교
 * AuthenticationProvider 인터페이스는 인증에 성공하면 인증된 Authentication 객체를 생성하여 리턴하기 때문에 비밀번호, 계정 활성화, 잠금 모든 부분에서 확인이 되었다면 리턴
 *
 */

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        // AuthenticaionFilter에서 생성된 토큰으로부터 아이디와 비밀번호를 조회
        String userId = (String) token.getPrincipal();
        String userPw = (String) token.getCredentials();
        // UserDetailsService를 통해 DB에서 아이디로 사용자 조회
        UserDetailsVO userDetailsVO = (UserDetailsVO) userDetailsService.loadUserByUsername(userId);

        if (!passwordEncoder.matches(userPw,  passwordEncoder.encode(userDetailsVO.getPassword()))) {
            throw new BadCredentialsException(userDetailsVO.getUsername() + "Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(userDetailsVO, userPw, userDetailsVO.getAuthorities());
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}