package com.example.felix_backend.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(FelixException.class)
    @ResponseBody
    public ApiResult validateHandler(RuntimeException ex) {
        return ApiResult.fail(ex.getMessage());
    }
}
