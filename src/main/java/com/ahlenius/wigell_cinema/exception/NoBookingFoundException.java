package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoBookingFoundException extends ParentExceptionClass {
    public NoBookingFoundException(String message) {
         super(message, HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.toString()); // Ska man lägga error likt detta på resten??
    }
}
