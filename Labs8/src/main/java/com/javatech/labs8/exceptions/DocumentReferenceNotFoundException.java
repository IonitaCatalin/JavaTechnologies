package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableNotFoundException;

public class DocumentReferenceNotFoundException extends TranslatableNotFoundException {
    public DocumentReferenceNotFoundException() {
        this.message = "Specified document's reference does not exists";
    }
}
