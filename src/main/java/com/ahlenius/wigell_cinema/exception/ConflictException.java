package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends ParentExceptionClass {
    public ConflictException(String message) {
        super(message, HttpStatus.CONFLICT,HttpStatus.CONFLICT.name());}}
