package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableNotFoundException;

public class AccountNotFoundException extends TranslatableNotFoundException {
    public AccountNotFoundException() {
        this.message = "Account with the submit credentials does not exists";
    }
}
