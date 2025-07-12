package com.salaon.userservice.payload.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExceptionResponse {
    private String message;
    private String error;
    private LocalDateTime timestamp;
}
