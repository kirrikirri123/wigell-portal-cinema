package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoMovieFoundException extends ParentExceptionClass {
    public NoMovieFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND,"No movie found");
    }
}
