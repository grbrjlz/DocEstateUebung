package com.docestate.immobilienservice.exceptions;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msg) {
        super(msg);
    }
    
}
