package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {


    @ExceptionHandler(NoCustomerFoundException.class)
    public ResponseEntity<?> NotFound(NoCustomerFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.NOT_FOUND.value()),
                        "error", "No customer found",
                        "message", e.getMessage()
                ));
    }
    @ExceptionHandler(NoMatchingAddressIdException.class)
    public ResponseEntity<?> NoFound(NoMatchingAddressIdException e) {
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
    @ExceptionHandler(NoMovieFoundException.class)
    public ResponseEntity<?> NotFound(NoMovieFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.NOT_FOUND.value()),
                        "error", "No movie found",
                        "message", e.getMessage()
                ));
    }

    @ExceptionHandler(NoBookingFoundException.class)
    public ResponseEntity<?> NotFound(NoBookingFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.NOT_FOUND.value()),
                        "error", "No bookning found",
                        "message", e.getMessage()
                ));
    }

    @ExceptionHandler(NoValidInputException.class)
    public ResponseEntity<?> BadInput(NoValidInputException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", (HttpStatus.BAD_REQUEST.value()),
                        "error", "Input invalid, no change done",
                        "message", e.getMessage()
                ));
    }

}
