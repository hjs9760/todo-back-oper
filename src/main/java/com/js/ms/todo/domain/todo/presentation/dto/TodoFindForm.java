package com.js.ms.todo.domain.todo.presentation.dto;

import com.js.ms.todo.domain.todo.domain.Status;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoFindForm {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
}
