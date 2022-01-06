package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableUnauthorizedException;

public class AccountInvalidCredentialsException extends TranslatableUnauthorizedException {
    public AccountInvalidCredentialsException() {
        this.message = "Account credentials are invalid";
    }

}
