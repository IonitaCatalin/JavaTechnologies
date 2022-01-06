package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableConflictException;

public class DocumentReferenceAlreadyExistsException extends TranslatableConflictException {
    public DocumentReferenceAlreadyExistsException() {
        this.message = "Specified reference for document already exist";
    }
}
