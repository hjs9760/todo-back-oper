package com.js.ms.todo.domain.member.application;

import com.js.ms.todo.domain.member.domain.Member;
import com.js.ms.todo.domain.member.domain.MemberRepository;
import com.js.ms.todo.domain.member.presentation.dto.SignInForm;
import com.js.ms.todo.domain.member.presentation.dto.UserInfo;
import com.js.ms.todo.global.config.Response.Response;
import com.js.ms.todo.global.config.exception.ErrorCode;
import com.js.ms.todo.global.config.exception.business.NotFoundException;
import com.js.ms.todo.global.config.security.jwt.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Response save(Member member) {
        if(!ObjectUtils.isEmpty(memberRepository.save(member))) {
            memberRepository.save(member);
            return Response.of("200", "성공적으로 회원가입 되었습니다.");
        } else {
            return Response.of(ErrorCode.MEMBER_SIGNUP_FAIL);
        }
    }

    public boolean chekId(String userId) {
        return memberRepository.existsByUserId(userId);
    }

    @Transactional
    public void checkEmailToken(String token, String email) {
        Member member = memberRepository.findByEmail(email);

        if(member == null) {
            throw new NotFoundException("등록된 이메일이 없습니다.");
        } else {
            member.convertEmailCheck(true);
        }
    }
    public Response signIn(SignInForm signInForm) {
        Member member = memberRepository.findByUserId(signInForm.getUserId());

        if(!member.isEmailCheck()) {
            return Response.of(ErrorCode.MEMBER_SIGNUP_EMAIL_FAIL);
        } else if(passwordEncoder.matches(signInForm.getPw(), member.getPw())) {
            return Response.of(ErrorCode.MEMBER_AUTHENTICATION_FAIL);
        } else {
            String jwt = JWTGenerator.generate(member.getId(), member.getEmail(), member.getRole());

            UserInfo userInfo = UserInfo.builder()
                                .userId(member.getUserId())
                                .birth(member.getBirth())
                                .name(member.getName())
                                .profileImage(member.getProfileImage())
                                .gender(member.getGender())
                                .role(member.getRole())
                                .email(member.getEmail())
                                .build();

            return Response.of("200", userInfo, jwt);
        }

    }
}
