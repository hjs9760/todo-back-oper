package com.js.ms.todo.domain.member.presentation.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SignUpForm {

    @NotBlank
    @Length(min = 4, max = 20)
    @Pattern(regexp = "^[ㄱ-ㅎ가=힣a-z0-9_-]{3,20}$")
    private String userId;

    @NotBlank
    private String pw;

    @NotBlank
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @NotBlank
    private String gender;

    private String profileImage;

    @Email
    @NotBlank
    private String email;

    public static String generateEmailCheckToken() {
        return UUID.randomUUID().toString();
    }


}
