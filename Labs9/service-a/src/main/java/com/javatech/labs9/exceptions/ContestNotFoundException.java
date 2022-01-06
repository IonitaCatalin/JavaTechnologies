package com.javatech.labs9.exceptions;

import com.javatech.labs9.exceptions.translatables.TranslatableNotFoundException;

public class ContestNotFoundException extends TranslatableNotFoundException {
    public ContestNotFoundException() {
        this.message = "Specified contest does not exist";
    }
}
