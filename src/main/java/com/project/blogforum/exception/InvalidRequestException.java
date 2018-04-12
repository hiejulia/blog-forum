package com.project.blogforum.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

    private static final long serialVersionUID = 1866382734645489314L;

    public InvalidRequestException(String message) {
        super(message);
    }
}