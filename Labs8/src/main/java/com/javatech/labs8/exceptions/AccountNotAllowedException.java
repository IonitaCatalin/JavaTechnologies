package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

import javax.ws.rs.core.Response;

public class AccountNotAllowedException extends TranslatableUnauthorizedException {
    public AccountNotAllowedException() {
        this.message = "The account owned by the user does not have permission level required";
    }
}
