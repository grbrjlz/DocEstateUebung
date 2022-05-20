package com.docestate.immobilienservice.exceptions;
/**
 * Exception fuer bereits existierende Immobilie
 */
public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String msg) {
        super(msg);
    }
    
}
