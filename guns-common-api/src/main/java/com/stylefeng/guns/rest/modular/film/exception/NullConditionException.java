package com.stylefeng.guns.rest.modular.film.exception;

public class NullConditionException extends RuntimeException {
    public NullConditionException() {
    }

    public NullConditionException(String message) {
        super(message);
    }
}
