package com.ahlenius.wigell_cinema.exception;

import org.springframework.http.HttpStatus;

abstract class ParentExceptionClass extends RuntimeException {
    private final HttpStatus status;
    private final String error;

    //ärver message från runtime som vanligt
    protected ParentExceptionClass(String message,HttpStatus status, String error) {
        super(message);
        this.status = status;
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
