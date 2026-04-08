package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoValidInputException extends ParentExceptionClass {
    public NoValidInputException(String message) {
        super(message, HttpStatus.BAD_REQUEST,"Input invalid, no changes made");
    }
}
