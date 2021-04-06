package com.js.ms.todo.domain.todo.presentation.dto;

import com.js.ms.todo.domain.todo.domain.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoInfo {

    private Long todoId;

    private String name;

    private String content;

    private Integer priority;

    private String status;

    private String statusName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String color;

    public static TodoInfo convertFrom(Todo todo) {
        TodoInfo todoInfo = new TodoInfo();

        todoInfo.todoId = todo.getId();
        todoInfo.name = todo.getName();
        todoInfo.content = todo.getContent();
        todoInfo.priority = todo.getPriority();
        todoInfo.status = todo.getStatus().toString();
        todoInfo.statusName = todo.getStatus().getName();
        todoInfo.startDate = todo.getStartDate();
        todoInfo.endDate = todo.getEndDate();
        todoInfo.color = todo.getStatus().getColor();

        return todoInfo;
    }
}
