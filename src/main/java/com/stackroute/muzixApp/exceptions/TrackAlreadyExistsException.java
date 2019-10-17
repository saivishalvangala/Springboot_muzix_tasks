package com.stackroute.muzixApp.exceptions;

public class TrackAlreadyExistsException extends Exception {
    private String message;

    public TrackAlreadyExistsException() {
    }

    public TrackAlreadyExistsException(String message1) {
        super(message1);
        this.message = message1;
    }
}
