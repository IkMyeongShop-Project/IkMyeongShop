package com.study.ikmyeongshopteam4.exception;

import lombok.Getter;

import java.util.Map;

public class CustomInternalServerException extends RuntimeException {

    @Getter
    private Map<String, String> errorMap;
    public CustomInternalServerException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

}
