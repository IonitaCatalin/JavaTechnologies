package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

public class AuthorizationMissingTokenException extends TranslatableUnauthorizedException {
    public AuthorizationMissingTokenException() {
        this.message = "Authorization token is required but it is missing";
    }
}
