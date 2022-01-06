package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableNotFoundException;

public class AccountNotFoundException extends TranslatableNotFoundException {
    public AccountNotFoundException() {
        this.message = "Account with the submit credentials does not exists";
    }
}
