package com.reactproject.reactProject.common.vo;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ResponseVO<T> {

    private T data;
    private HttpStatus status;
    private String message;

    @Builder(builderMethodName = "of")
    public ResponseVO(T data, HttpStatus status) {
        this.data = data;
        this.status = status;
        this.message = "not Message";
    }

    @Builder(builderMethodName = "error")
    public ResponseVO(T data, HttpStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }
}