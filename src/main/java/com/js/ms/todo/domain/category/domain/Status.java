package com.js.ms.todo.domain.category.domain;

import lombok.Getter;

@Getter
public enum Status {

    PROGRESS("진행"),
    COMPLETE("완료"),
    STATELESS("상태없음"),
    ;

    private String name;

    Status(String name) {
        this.name = name;
    }

}
