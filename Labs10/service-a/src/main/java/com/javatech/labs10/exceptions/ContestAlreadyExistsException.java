package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableConflictException;

public class ContestAlreadyExistsException extends TranslatableConflictException {
    public ContestAlreadyExistsException() {
        this.message = "Specified contest name already exists";
    }
}
