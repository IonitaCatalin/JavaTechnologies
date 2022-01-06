package com.javatech.labs10.exceptions;

import com.javatech.labs10.exceptions.translatables.TranslatableNotFoundException;

public class ContestNotFoundException extends TranslatableNotFoundException {
    public ContestNotFoundException() {
        this.message = "Specified contest does not exist";
    }
}
