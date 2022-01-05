package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

public class DocumentInvalidOwnershipException extends TranslatableUnauthorizedException {
    public DocumentInvalidOwnershipException() {
        this.message = "Specified account does not have right over the specified document";
    }
}
