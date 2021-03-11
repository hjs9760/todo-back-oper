package com.js.ms.todo.domain.member.presentation;

import com.js.ms.todo.domain.member.application.MailService;
import com.js.ms.todo.domain.member.application.MemberService;
import com.js.ms.todo.domain.member.domain.Member;
import com.js.ms.todo.domain.member.presentation.dto.EmailCheckForm;
import com.js.ms.todo.domain.member.presentation.dto.SignInForm;
import com.js.ms.todo.domain.member.presentation.dto.SignUpForm;
import com.js.ms.todo.global.config.Response.Response;
import com.js.ms.todo.global.config.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    @GetMapping("checkId")
    public boolean chekId(@RequestParam String userId) {
        return memberService.chekId(userId);
    }


    @PostMapping("/signUp")
    public Response signUp(@Valid @RequestBody SignUpForm signUpForm) {
        Member member = Member.builder()
                .userId(signUpForm.getUserId())
                .pw(passwordEncoder.encode(signUpForm.getPw()))
                .name(signUpForm.getName())
                .birth(signUpForm.getBirth())
                .gender(signUpForm.getGender())
                .email(signUpForm.getEmail())
                .emailCheckToken(SignUpForm.generateEmailCheckToken())
                .joinAt(LocalDateTime.now())
                .build();

        memberService.save(member);

        return mailService.sendMail(member);
    }

    @PostMapping("/checkEmail")
    public Response checkEmail(@Valid @RequestBody EmailCheckForm emailCheckForm) {
        if (ObjectUtils.isEmpty(emailCheckForm.getEmailCheckToken()))
            return Response.of(ErrorCode.INVALID_INPUT_VALUE, "이메일 인증코드값이 비어있습니다.");

        return mailService.checkEmail(emailCheckForm);
    }

    @PostMapping("/signIn")
    public Response signIn(@Valid @RequestBody SignInForm signInForm) {
        return memberService.signIn(signInForm);
    }

    @GetMapping("/checkEmailToken")
    public void checkEmailToken(String token, String email) {
        memberService.checkEmailToken(token, email);
    }


}
