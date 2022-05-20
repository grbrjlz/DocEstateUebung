package com.docestate.immobilienservice.exceptions;
/**
 * Exception fuer nicht gefundene Immobilie
 */
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String msg) {
        super(msg);
    }
    
}
