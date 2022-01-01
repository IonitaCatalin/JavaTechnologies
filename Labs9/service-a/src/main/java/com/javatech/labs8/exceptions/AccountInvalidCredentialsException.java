package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

public class AccountInvalidCredentialsException extends TranslatableUnauthorizedException {
    public AccountInvalidCredentialsException() {
        this.message = "Account credentials are invalid";
    }

}
