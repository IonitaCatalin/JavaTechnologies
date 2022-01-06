package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableBadRequestException;

public class ContestNotRunningException extends TranslatableBadRequestException {
    public ContestNotRunningException() {
        this.message = "The contest does not accept new entries";
    }
}
