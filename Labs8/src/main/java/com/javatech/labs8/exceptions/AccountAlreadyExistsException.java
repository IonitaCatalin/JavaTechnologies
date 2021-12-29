package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableConflictException;
import com.javatech.labs8.exceptions.translatables.TranslatableNotFoundException;

import javax.ejb.ApplicationException;

public class AccountAlreadyExistsException extends TranslatableConflictException {
    public AccountAlreadyExistsException() {
        super();
    }
}
