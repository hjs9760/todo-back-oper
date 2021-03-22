package com.js.ms.todo.domain.section.presentation.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SectionSaveForm {

    @NotNull
    private Long categoryId;

    @NotNull
    private String name;
}
