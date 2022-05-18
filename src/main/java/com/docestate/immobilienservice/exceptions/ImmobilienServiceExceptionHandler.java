package com.docestate.immobilienservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception Handler
 */
@ControllerAdvice
public class ImmobilienServiceExceptionHandler {
     
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<String> handleEntityAlreadyExistsException(EntityAlreadyExistsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
