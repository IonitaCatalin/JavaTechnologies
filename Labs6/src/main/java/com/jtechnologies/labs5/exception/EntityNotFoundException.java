package com.jtechnologies.labs5.exception;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
