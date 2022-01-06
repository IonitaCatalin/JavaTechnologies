package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableNotFoundException;

public class DocumentReferenceNotFoundException extends TranslatableNotFoundException {
    public DocumentReferenceNotFoundException() {
        this.message = "Specified document's reference does not exists";
    }
}
