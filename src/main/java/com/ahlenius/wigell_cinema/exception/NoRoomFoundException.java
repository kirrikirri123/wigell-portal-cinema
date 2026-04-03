package com.ahlenius.wigell_cinema.exception;

public class NoRoomFoundException extends RuntimeException {
    public NoRoomFoundException(String message) {
        super(message);
    }
}
