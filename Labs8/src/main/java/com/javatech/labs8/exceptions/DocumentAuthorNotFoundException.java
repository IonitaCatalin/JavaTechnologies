package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableNotFoundException;

public class DocumentAuthorNotFoundException extends TranslatableNotFoundException {
    public DocumentAuthorNotFoundException() {
        this.message = "Specified document's author does not exist";
    }
}
