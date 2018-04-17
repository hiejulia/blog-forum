package com.project.blogforum.messaging.exception;

public class NoRabbitAdminException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoRabbitAdminException() {

    }

    public NoRabbitAdminException(String message) {
        super(message);
    }
}