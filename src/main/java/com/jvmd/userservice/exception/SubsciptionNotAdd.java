package com.jvmd.userservice.exception;

public class SubsciptionNotAdd extends RuntimeException {
    public SubsciptionNotAdd(String message) {
        super(
         "Subsciption not add: " +          message
        );
    }
}
