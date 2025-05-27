package com.jvmd.userservice.exception;

public class UserNotSaveException extends RuntimeException {
    public UserNotSaveException(String message) {
        super("User not save: " + message);
    }
}
