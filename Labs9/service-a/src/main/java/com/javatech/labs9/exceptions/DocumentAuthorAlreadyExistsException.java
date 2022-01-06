package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableConflictException;

public class DocumentAuthorAlreadyExistsException extends TranslatableConflictException {
    public DocumentAuthorAlreadyExistsException() {
        this.message = "Specified document's author does not exist";
    }
}
