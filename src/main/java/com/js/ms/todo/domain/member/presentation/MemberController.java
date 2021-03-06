package com.js.ms.todo.domain.member.presentation;

import com.js.ms.todo.domain.member.application.MemberService;
import com.js.ms.todo.domain.member.domain.Member;
import com.js.ms.todo.domain.member.presentation.dto.SignInForm;
import com.js.ms.todo.domain.member.presentation.dto.SignUpForm;
import com.js.ms.todo.domain.member.presentation.dto.SignUpFormValidator;
import com.js.ms.todo.global.config.Response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final SignUpFormValidator signUpFormValidator;
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder passwordEncoder;


    @InitBinder("signUpForm")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(signUpFormValidator);
    }

    @GetMapping("checkId")
    public boolean chekId(@RequestParam String userId) {
        return memberService.chekId(userId);
    }


    @PostMapping("/signUp")
    public Response signUp(@Valid @RequestBody SignUpForm signUpForm, Errors errors) {
        Member member =  Member.builder()
                .userId(signUpForm.getUserId())
                .pw(passwordEncoder.encode(signUpForm.getPw()))
                .name(signUpForm.getName())
                .birth(signUpForm.getBirth())
                .gender(signUpForm.getGender())
                .email(signUpForm.getEmail())
                .joinAt(LocalDateTime.now())
                .build();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(member.getEmail());
        mailMessage.setSubject("Todolist, 회원 인증");
        mailMessage.setText("이메일 체크를 부탁드립니다. token=" + member.generateEmailCheckToken()  + "?email=" + member.getEmail());
        javaMailSender.send(mailMessage);

        return memberService.save(member);
    }

    @PostMapping("/signIn")
    public Response signIn(@Valid @RequestBody SignInForm signInForm, Errors errors) {
        Member member =  Member.builder()
                .userId(signInForm.getUserId())
                .pw(passwordEncoder.encode(signInForm.getPw()))
                .build();

        return memberService.save(member);
    }


    @GetMapping("/checkEmailToken")
    public void checkEmailToken(String token, String email) {
        memberService.checkEmailToken(token, email);
    }



}
