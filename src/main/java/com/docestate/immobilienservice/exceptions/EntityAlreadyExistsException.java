package com.docestate.immobilienservice.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String msg) {
        super(msg);
    }
    
}
