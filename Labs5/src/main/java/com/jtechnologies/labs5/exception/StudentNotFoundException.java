package com.jtechnologies.labs5.exception;

public class StudentNotFoundException extends Exception{
    public StudentNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
