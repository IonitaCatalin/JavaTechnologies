package com.javatech.labs8.exceptions;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

public class RequestNotAllowedException extends TranslatableUnauthorizedException {
    public RequestNotAllowedException() {
        this.message = "The account owned by the user does not have permission level required";
    }
}
