package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

public class InvalidTokenException extends TranslatableUnauthorizedException {
    public InvalidTokenException() {
        this.message = "Provided token is invalid";
    }
}
