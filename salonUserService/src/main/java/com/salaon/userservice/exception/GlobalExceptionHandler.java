package com.salaon.userservice.exception;

import com.salaon.userservice.payload.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ExceptionResponse> userExceptionHandler(UserException ex, WebRequest req)
    {
        ExceptionResponse exceptionResponse=ExceptionResponse.builder().message(ex.getMessage()).error(ex.getMessage()).timestamp(LocalDateTime.now()).build();
        System.out.println(exceptionResponse);
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
