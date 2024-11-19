package ru.edu.springauth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, msg);
    }
}
