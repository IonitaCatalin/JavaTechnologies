package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableUnauthorizedException;

public class AccountInvalidTokenException extends TranslatableUnauthorizedException {
    public AccountInvalidTokenException() {
        this.message = "Provided token is invalid";
    }
}
