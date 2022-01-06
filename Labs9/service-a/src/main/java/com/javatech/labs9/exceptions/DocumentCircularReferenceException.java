package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableBadRequestException;

public class DocumentCircularReferenceException extends TranslatableBadRequestException {
    public DocumentCircularReferenceException() {
        this.message = "Adding specified reference to the document will create a circular reference";
    }
}
