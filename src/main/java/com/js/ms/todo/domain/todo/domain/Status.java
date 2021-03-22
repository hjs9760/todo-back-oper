package com.js.ms.todo.domain.todo.domain;

import lombok.Getter;

@Getter
public enum Status {

    PLAN("계획"),
    PROGRESS("진행"),
    COMPLETE("완료"),
    PROBLEM("문제"),
    HOLD("보류")
    ;

    private String name;

    Status(String name) {
        this.name = name;
    }

}
