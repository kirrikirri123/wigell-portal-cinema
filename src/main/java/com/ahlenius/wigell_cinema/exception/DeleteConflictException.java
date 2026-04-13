package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

public class DeleteConflictException extends ParentExceptionClass {
    public DeleteConflictException(String message) {
        super(message, HttpStatus.CONFLICT,HttpStatus.CONFLICT.name());}}
