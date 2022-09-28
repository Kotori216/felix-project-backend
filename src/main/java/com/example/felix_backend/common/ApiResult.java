package com.example.felix_backend.common;

import lombok.Data;

@Data
public class ApiResult<T> {
    public static ApiResult success() {
        return new ApiResult(true, "200", "success");
    }

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(true, "200", "success", data);
    }

    public static ApiResult notModified() {
        return new ApiResult(true, "304", "Not Modified");
    }

    public static ApiResult fail(String message) {
        return new ApiResult(false, "500", message);
    }

    public ApiResult() {
    }

    public ApiResult(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResult(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ApiResult(Boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Boolean success = Boolean.TRUE;
    private String code;
    private String message;
    private T data;
}