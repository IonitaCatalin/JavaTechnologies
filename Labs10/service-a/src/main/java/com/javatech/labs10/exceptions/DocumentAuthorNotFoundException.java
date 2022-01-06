package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableNotFoundException;

public class DocumentAuthorNotFoundException extends TranslatableNotFoundException {
    public DocumentAuthorNotFoundException() {
        this.message = "Specified document's author does not exist";
    }
}
