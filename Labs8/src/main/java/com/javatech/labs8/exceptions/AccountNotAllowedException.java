package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

import javax.ws.rs.core.Response;

public class AccountNotAllowedException extends TranslatableUnauthorizedException {
    public AccountNotAllowedException() {
        this.code = "ERROR_ACCOUNT_INSUFFICIENT_PERMISSIONS";
        this.message = "The account owned by the user does not have permission level required";
        this.http = Response.Status.UNAUTHORIZED.getStatusCode();
    }
}
