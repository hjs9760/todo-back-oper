package com.js.ms.todo.domain.todo.presentation.dto;

import com.js.ms.todo.domain.todo.domain.Status;
import com.js.ms.todo.domain.todo.domain.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoInfo {

    private Long todoId;

    private String name;

    private String content;

    private Integer priority;

    private Status status;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public static TodoInfo convertFrom(Todo todo) {
        TodoInfo todoInfo = new TodoInfo();

        todoInfo.todoId = todo.getId();
        todoInfo.name = todo.getName();
        todoInfo.content = todo.getContent();
        todoInfo.priority = todo.getPriority();
        todoInfo.status = todo.getStatus();
        todoInfo.startDate = todo.getStartDate();
        todoInfo.endDate = todo.getEndDate();

        return todoInfo;
    }
}
