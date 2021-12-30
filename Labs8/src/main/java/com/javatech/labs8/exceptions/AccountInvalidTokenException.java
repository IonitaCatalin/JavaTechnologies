package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

public class AccountInvalidTokenException extends TranslatableUnauthorizedException {
    public AccountInvalidTokenException() {
        this.message = "Provided token is invalid";
    }
}
