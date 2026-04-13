package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class NoRoomFoundException extends ParentExceptionClass {
    public NoRoomFoundException (String message) {
        super(message, HttpStatus.NO_CONTENT,HttpStatus.NO_CONTENT.name());
    }
}
