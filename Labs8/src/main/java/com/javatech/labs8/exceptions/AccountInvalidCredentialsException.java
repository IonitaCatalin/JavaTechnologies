package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

import javax.ws.rs.core.Response;

public class AccountInvalidCredentialsException extends TranslatableUnauthorizedException {
    public AccountInvalidCredentialsException() {
        this.message = "Account credentials are invalid";
    }

}
