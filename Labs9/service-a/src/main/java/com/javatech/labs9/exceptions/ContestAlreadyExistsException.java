package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableConflictException;

public class ContestAlreadyExistsException extends TranslatableConflictException {
    public ContestAlreadyExistsException() {
        this.message = "Specified contest name already exists";
    }
}
