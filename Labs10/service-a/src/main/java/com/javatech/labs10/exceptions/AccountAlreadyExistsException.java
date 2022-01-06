package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableConflictException;


public class AccountAlreadyExistsException extends TranslatableConflictException {

    public AccountAlreadyExistsException() {
        this.message = "Account exists with credentials";
    }
}
