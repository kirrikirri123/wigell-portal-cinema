package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    //mall
    @ExceptionHandler(NoSuchMemberFoundException.class)
    public ResponseEntity<?> NotFound(NoSuchMemberFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.NOT_FOUND.value()),
                        "error", "No member found",
                        "message", e.getMessage()
                ));
    }


}
