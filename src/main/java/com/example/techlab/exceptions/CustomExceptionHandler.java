package com.example.techlab.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorException> handleCustomException(CustomException exception){
        CustomErrorException customErrorException= new CustomErrorException();
        customErrorException.setTimestamp(LocalDateTime.now());
        customErrorException.setError(exception.getMessage());
        customErrorException.setStatus(exception.getStatus());
        return  new ResponseEntity<>(customErrorException,exception.getStatus());
    }
}
