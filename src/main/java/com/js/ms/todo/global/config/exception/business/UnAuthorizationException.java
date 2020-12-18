package com.js.ms.todo.global.config.exception.business;

import com.js.ms.todo.global.config.exception.ErrorCode;

public class UnAuthorizationException extends BusinessException {

    public UnAuthorizationException() {
        super(ErrorCode.MEMBER_AUTHORIZATION_DENIED);
    }
}
