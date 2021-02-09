package com.js.ms.todo.global.config.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // Common
    // input type 예외
    INVALID_INPUT_VALUE( "A001"),
    // 미존재 데이터 예외
    NOT_FOUND_ROW("A002"),
    // 종복 예외
    DUPLICATE_ROW("A003"),
    // Server 예외
    INTERNAL_SERVER_ERROR("A010"),


    // Member
    // 인증 예외
    MEMBER_AUTHENTICATION_FAIL("B001", "Member Authentication Exception"),
    // 인가 예외
    MEMBER_AUTHORIZATION_DENIED("B002", "Member AUTHORIZATION Exception");


    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorCode(String code) {
        this.code = code;
    }
}
