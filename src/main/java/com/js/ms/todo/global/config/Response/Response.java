package com.js.ms.todo.global.config.Response;

import com.js.ms.todo.global.config.exception.ErrorCode;
import lombok.Getter;

@Getter
public class Response {
    private String code;
    private String message;

    // 실패
    public static Response of(ErrorCode errorCode, String message) {
        Response response = new Response();

        response.code = errorCode.getCode();
        response.message = message;

        return response;
    }

    public static Response of(ErrorCode errorCode) {
        Response response = new Response();

        response.code = errorCode.getCode();
        response.message = errorCode.getMessage();

        return response;
    }


    // 성공
    public static Response of(String code, String message) {
        Response response = new Response();

        response.code = code;
        response.message = message;

        return response;
    }
}
