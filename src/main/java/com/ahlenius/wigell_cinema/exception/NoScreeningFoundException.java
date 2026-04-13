package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoScreeningFoundException extends ParentExceptionClass {
    public NoScreeningFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND,HttpStatus.NOT_FOUND.name());
    }
}
