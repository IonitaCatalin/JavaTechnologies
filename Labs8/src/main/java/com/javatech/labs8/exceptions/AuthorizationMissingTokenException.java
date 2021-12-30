package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

import javax.ws.rs.core.Response;

public class AuthorizationMissingTokenException extends TranslatableUnauthorizedException {
    public AuthorizationMissingTokenException() {
        this.code = "ERROR_MISSING_AUTH_SCHEMA_TOKEN";
        this.http = Response.Status.FORBIDDEN.getStatusCode();
        this.message = "Authorization token is required but it is missing";
    }
}
