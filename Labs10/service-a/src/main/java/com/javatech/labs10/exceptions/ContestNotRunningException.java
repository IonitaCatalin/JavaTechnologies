package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableBadRequestException;

public class ContestNotRunningException extends TranslatableBadRequestException {
    public ContestNotRunningException() {
        this.message = "The contest does not accept new entries";
    }
}
