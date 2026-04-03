package com.ahlenius.wigell_cinema.exception;

public class NoMovieFoundException extends RuntimeException {
    public NoMovieFoundException(String message) {
        super(message);
    }
}
