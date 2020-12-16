package com.js.ms.todo.global.config.exception.business;


import com.js.ms.todo.global.config.exception.ErrorCode;

public class DuplicateException extends BusinessException {

    public DuplicateException(String message) {
        super(ErrorCode.DUPLICATE_ROW, message);
    }
}
