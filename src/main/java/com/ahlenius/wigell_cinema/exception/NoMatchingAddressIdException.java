package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoMatchingAddressIdException extends ParentExceptionClass {
    public NoMatchingAddressIdException(String message) {
        super(message, HttpStatus.NOT_FOUND,"No matching address id");
    }
}
