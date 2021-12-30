package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableNotFoundException;

import javax.ws.rs.core.Response;

public class AccountNotFoundException extends TranslatableNotFoundException {
    public AccountNotFoundException() {
        this.http = Response.Status.NOT_FOUND.getStatusCode();
        this.code = "ERROR_ACCOUNT_NOT_FOUND";
        this.message = "Account with the submit credentials does not exists";
    }
}
