package com.ahlenius.wigell_cinema.exception;

public class NoMatchingAddressIdException extends RuntimeException {
    public NoMatchingAddressIdException(String message) {
        super(message);
    }
}
