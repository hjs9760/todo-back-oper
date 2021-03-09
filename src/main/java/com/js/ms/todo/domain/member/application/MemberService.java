package com.js.ms.todo.domain.member.application;

import com.js.ms.todo.domain.member.domain.Member;
import com.js.ms.todo.domain.member.domain.MemberRepository;
import com.js.ms.todo.global.config.Response.Response;
import com.js.ms.todo.global.config.exception.ErrorCode;
import com.js.ms.todo.global.config.exception.business.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

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

    public void checkEmailToken(String token, String email) {
        Member member = memberRepository.findByEmail(email);

        if(member == null) {
            throw new NotFoundException("등록된 이메일이 없습니다.");
        } else {
            member.convertEmailCheck(true);
        }
    }
}
