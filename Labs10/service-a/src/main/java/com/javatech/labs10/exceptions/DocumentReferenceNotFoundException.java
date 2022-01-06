package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableNotFoundException;

public class DocumentReferenceNotFoundException extends TranslatableNotFoundException {
    public DocumentReferenceNotFoundException() {
        this.message = "Specified document's reference does not exists";
    }
}
