package com.project.blogforum.messaging.exception;



public class NoQueuFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoQueuFoundException() {

    }

    public NoQueuFoundException(String message) {
        super(message);
    }
}