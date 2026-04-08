package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponse(
        String timestamp,
        String status,
        String error,
        String message
) {
    public static ErrorResponse of(HttpStatus status, String error, String message) {
        return new ErrorResponse(
                LocalDateTime.now().toString(), // skapas 'automatiskt' så därför behöver inte läggas in i konstruktorn.
                status.toString(), // gör om från httpstatus i barn exceptions till string.
                error,
                message);
    }

}
