package com.js.ms.todo.domain.member.presentation.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class EmailCheckForm {
    @NotBlank
    private String userId;
    @NotBlank
    private String emailCheckToken;
}
