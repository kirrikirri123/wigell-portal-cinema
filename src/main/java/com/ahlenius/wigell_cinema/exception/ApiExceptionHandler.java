package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {


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

    @ExceptionHandler(NoMatchingAddressIdException.class)
    public ResponseEntity<?> NoMatch(NoMatchingAddressIdException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.NOT_FOUND.value()),
                        "error", "No matching address id",
                        "message", e.getMessage()
                ));
    }
    @ExceptionHandler(ResponseIsNullException.class)
    public ResponseEntity<?> Null(ResponseIsNullException e) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.NO_CONTENT.value()),
                        "error", "No value to return",
                        "message", e.getMessage()
                ));
    }
}
