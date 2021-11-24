package com.jtechnologies.labs5.exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
