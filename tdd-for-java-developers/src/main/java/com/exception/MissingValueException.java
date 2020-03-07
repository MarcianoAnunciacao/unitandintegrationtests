package com.exception;

public class MissingValueException extends RuntimeException{


    public MissingValueException(String message) {
        super(message);
    }
}
