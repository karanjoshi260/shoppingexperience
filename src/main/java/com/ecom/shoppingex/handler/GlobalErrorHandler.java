package com.ecom.shoppingex.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;

@ControllerAdvice
public class GlobalErrorHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handle(Exception exception){
        LOGGER.error("Internal Error", exception);
        ErrorResponse errorResponse = ErrorResponse.builder(exception,HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).build();
        ResponseEntity<ErrorResponse> response = new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return response;
    }
}
