package com.solanteq.controller.Exceptions;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsResolver {

    @ExceptionHandler(BadRequestParamsException.class)
    public ResponseEntity<Error> badRequestParams(BadRequestParamsException e) {
        Error error;
        if(e.getMessage().contains("IllegalArgumentException"))
            error = new Error(4, "date is incorrect");
        else
            error = new Error(4, e.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<Error> illegalArgument(){
        Error error = new Error(4, "Incorrect parameters format");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> allOtherException(Exception e) {
        Error error = new Error(5, e.getMessage());
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
