package com.project.blogforum.exception;


public class BadCodeRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -2411444965751028974L;

    public BadCodeRuntimeException(String message) {
        super(message);
    }

}