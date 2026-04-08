package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoCustomerFoundException extends ParentExceptionClass {
    public NoCustomerFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND,"No customer found");
    }
}
