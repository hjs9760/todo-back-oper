package com.js.ms.todo.domain.mail.presentation;

import com.js.ms.todo.domain.mail.application.MailService;
import com.js.ms.todo.global.config.Response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/sendEmail")
    public Response sendMail(@RequestParam String userId) {
        return mailService.sendMail(userId);
    }

    @GetMapping("/checkEmail")
    public Response checkEmail(@RequestParam String userId, @RequestParam String emailCheckToken) {
        return mailService.checkEmail(userId, emailCheckToken);
    }


}
