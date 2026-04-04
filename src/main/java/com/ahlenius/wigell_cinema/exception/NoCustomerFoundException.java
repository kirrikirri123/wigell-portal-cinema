package com.ahlenius.wigell_cinema.exception;

public class NoCustomerFoundException extends RuntimeException {
    public NoCustomerFoundException(String message) {
        super(message);
    }
}
