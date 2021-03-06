package com.js.ms.todo.global.config.exception.business;


import com.js.ms.todo.global.config.exception.ErrorCode;
import lombok.Getter;

public class BusinessException extends RuntimeException {

    @Getter
    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message) {
        super(message);
    }
}
