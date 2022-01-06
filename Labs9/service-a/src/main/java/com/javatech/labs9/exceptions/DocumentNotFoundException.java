package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableNotFoundException;

public class DocumentNotFoundException extends TranslatableNotFoundException {
    public DocumentNotFoundException() {
        this.message = "Requested document does not exist";
    }
}
