package com.js.ms.todo.domain.member.application;

import com.js.ms.todo.domain.member.domain.Member;
import com.js.ms.todo.domain.member.domain.MemberRepository;
import com.js.ms.todo.domain.member.presentation.dto.EmailCheckForm;
import com.js.ms.todo.global.config.Response.Response;
import com.js.ms.todo.global.config.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MailService {

    @Value("${mail.username}")
    private String mailFrom;
    private final JavaMailSender javaMailSender;
    private final MemberRepository memberRepository;

    @Transactional
    public Response sendMail(Member member) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(member.getEmail());
        mailMessage.setFrom(mailFrom);
        mailMessage.setSubject("Todolist, 회원 인증");
        mailMessage.setText("이메일 인증코드 입력을 해주세요. \n인증코드=" + member.getEmailCheckToken());
        javaMailSender.send(mailMessage);

        return Response.of("200", "정상적으로 가입되었습니다. \n이메일 인증후 서비스 이용이 가능합니다.");
    }

    @Transactional
    public Response checkEmail(EmailCheckForm emailCheckForm) {
        Member member = memberRepository.findByUserId(emailCheckForm.getUserId());

        if(member.getEmailCheckToken().equals(emailCheckForm.getEmailCheckToken())) {
            member.convertEmailCheck(true);
            return Response.of("200", "인증에 성공했습니다. \n정상적으로 서비스 이용이 가능합니다.");
        } else {
            return Response.of(ErrorCode.MEMBER_SIGNUP_EMAIL_FAIL);
        }
    }
}
