package com.study.ikmyeongshopteam4.exception;

import lombok.Getter;

import java.util.Map;

public class CustomInternalServerErrorException extends RuntimeException {

    @Getter
    private Map<String, String> errorMap;
    public CustomInternalServerErrorException(String message) {
        super(message);
    }

}
