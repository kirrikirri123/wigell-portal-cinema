package com.ahlenius.wigell_cinema.exception;

public class NoBookingFoundException extends RuntimeException {
    public NoBookingFoundException(String message) {
        super(message);
    }
}
