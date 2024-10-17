package com.tl.user.service;

import org.springframework.http.HttpStatus;

import lombok.Getter;

// 使用ApiResponse封装返回信息
public class ApiResponse<T> {
    // lombok的注解，自动生成getter
    @Getter
    private int status;
    @Getter
    private String message;
    @Getter
    private T data;

    public ApiResponse() {}

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<T>(HttpStatus.OK.value(), "Success", data);
    }

    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<T>(status, message, null);
    }

    public static <T> ApiResponse<T> error(int status) {
        return new ApiResponse<T>(status, "Error", null);
    }
}
