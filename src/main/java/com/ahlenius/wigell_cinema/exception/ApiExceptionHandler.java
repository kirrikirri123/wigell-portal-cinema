package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ParentExceptionClass.class) // 'allt' som kommer via runtime
    public ResponseEntity<ErrorResponse> handleExceptions(ParentExceptionClass e) {
        return ResponseEntity.status(e.getStatus()).body(ErrorResponse.of(e.getStatus(), e.getError(), e.getMessage()));
    }

    @ExceptionHandler(Exception.class) // det som kommer som exception, oväntade fel.
    public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
                        e.getMessage(), // vilka meddelanden kommer ut? vad vill man skydda/ förklara annars? ex. No static resource api/v1."
                        "Ett oväntat fel uppstod."));
    }


}
