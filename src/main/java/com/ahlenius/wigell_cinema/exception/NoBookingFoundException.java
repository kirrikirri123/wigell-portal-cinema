package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoBookingFoundException extends ParentExceptionClass {
    public NoBookingFoundException(String message) {
         super(message, HttpStatus.NOT_FOUND,"No booking found");
    }
}
