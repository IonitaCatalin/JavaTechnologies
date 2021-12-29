package com.javatech.labs8.exceptions.translatables;

import javax.ejb.ApplicationException;

@ApplicationException
public class TranslatableNotFoundException extends TranslatableException{

    public TranslatableNotFoundException() {
        this.http = 404;
    }

}
