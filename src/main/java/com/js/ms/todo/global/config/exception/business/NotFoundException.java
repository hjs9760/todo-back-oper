package com.js.ms.todo.global.config.exception.business;


import com.js.ms.todo.global.config.exception.ErrorCode;

public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(ErrorCode.NOT_FOUND_ROW, message);
    }
}
