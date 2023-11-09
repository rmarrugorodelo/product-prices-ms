package com.rmarrugo.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends Exception{

    private final String message;

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

}
