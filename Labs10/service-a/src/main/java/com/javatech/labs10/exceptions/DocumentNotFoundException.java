package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableNotFoundException;

public class DocumentNotFoundException extends TranslatableNotFoundException {
    public DocumentNotFoundException() {
        this.message = "Requested document does not exist";
    }
}
