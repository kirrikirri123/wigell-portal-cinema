package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        String timestamp,
        int status,
        String error,
        String message
) {
    public static ErrorResponse of(HttpStatus status, String error, String message) {
        return new ErrorResponse(
                LocalDateTime.now().toString(),
                status.value(),
                error,
                message);
    }

}
