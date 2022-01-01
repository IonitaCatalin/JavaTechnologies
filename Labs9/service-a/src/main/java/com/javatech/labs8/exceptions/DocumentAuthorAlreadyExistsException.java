package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableConflictException;

public class DocumentAuthorAlreadyExistsException extends TranslatableConflictException {
    public DocumentAuthorAlreadyExistsException() {
        this.message = "Specified document's author does not exist";
    }
}
