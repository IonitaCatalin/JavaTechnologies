package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableUnauthorizedException;

public class AccountNotAllowedException extends TranslatableUnauthorizedException {
    public AccountNotAllowedException() {
        this.message = "The account owned by the user does not have permission level required";
    }
}
