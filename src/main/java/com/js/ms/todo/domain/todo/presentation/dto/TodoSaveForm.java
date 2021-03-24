package com.js.ms.todo.domain.todo.presentation.dto;

import com.js.ms.todo.domain.todo.domain.Status;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class TodoSaveForm {

    @NotNull
    private Long sectionId;

    @NotBlank
    private String name;

    private String content;

    @NotNull
    private Integer priority;

    @NotNull
    private Status status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
