package com.training.weatherservice.exceptions;

public class NotFound extends RuntimeException {

    private static final long serialVersionUID = 2941757472591406805L;

    public NotFound() {
        super("Register does not exist");
    }

}
