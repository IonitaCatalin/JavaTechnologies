package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableUnauthorizedException;

public class AccountInvalidCredentialsException extends TranslatableUnauthorizedException {
    public AccountInvalidCredentialsException() {
        this.message = "Account credentials are invalid";
    }

}
