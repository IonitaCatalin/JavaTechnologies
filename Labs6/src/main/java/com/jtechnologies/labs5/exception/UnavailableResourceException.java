package com.jtechnologies.labs5.exception;

public class UnavailableResourceException extends Exception{
    public UnavailableResourceException(String errorMessage) {
        super(errorMessage);
    }
}
