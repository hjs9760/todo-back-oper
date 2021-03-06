package com.js.ms.todo.domain.member.presentation.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class SignInForm {

    @NotBlank
    private String userId;
    @NotBlank
    private String pw;

}
