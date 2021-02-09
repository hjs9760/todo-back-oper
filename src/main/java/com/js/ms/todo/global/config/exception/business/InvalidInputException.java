package com.js.ms.todo.global.config.exception.business;

import com.js.ms.todo.global.config.exception.ErrorCode;

public class InvalidInputException extends BusinessException {
    public InvalidInputException(String message) {
        super(ErrorCode.INVALID_INPUT_VALUE, message);
    }
}
