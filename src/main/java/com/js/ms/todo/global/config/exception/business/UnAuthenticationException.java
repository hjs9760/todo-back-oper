package com.js.ms.todo.global.config.exception.business;


import com.js.ms.todo.global.config.exception.ErrorCode;

public class UnAuthenticationException extends BusinessException {

    public UnAuthenticationException() {
        super(ErrorCode.MEMBER_AUTHENTICATION_FAIL);
    }
}
