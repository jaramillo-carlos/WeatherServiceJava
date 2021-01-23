package com.training.weatherservice.exceptions;

public class DuplicatedException extends RuntimeException {

    private static final long serialVersionUID = -4134616496713007647L;

    public DuplicatedException() {
        super("Register exist");
    }
}
