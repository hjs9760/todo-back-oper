package com.js.ms.todo.domain.category.domain;

import lombok.Getter;

@Getter
public enum Status {

    PROGRESS("진행","green"),
    COMPLETE("완료", "blue"),
    STATELESS("상태없음", "grey"),
    ;

    private String name;
    private String color;

    Status(String name, String color) {
        this.name = name;
        this.color = color;
    }

}
