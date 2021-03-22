package com.js.ms.todo.domain.section.presentation.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class SectionUpdateForm {

    @NotNull
    private Long categoryId;

    @NotNull
    private Long sectionId;

    @NotNull
    private String name;
}
