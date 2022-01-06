package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableUnauthorizedException;

public class AccountInvalidTokenException extends TranslatableUnauthorizedException {
    public AccountInvalidTokenException() {
        this.message = "Provided token is invalid";
    }
}
