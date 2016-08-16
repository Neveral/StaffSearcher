package com.solanteq.controller.Exceptions;

public class BadRequestParamsException extends RuntimeException {
    public BadRequestParamsException(String message) {
        super(message);
    }
}
