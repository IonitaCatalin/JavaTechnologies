package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableConflictException;


public class AccountAlreadyExistsException extends TranslatableConflictException {

    public AccountAlreadyExistsException() {
        this.message = "Account exists with credentials";
    }
}
