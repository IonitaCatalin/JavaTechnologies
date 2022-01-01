package com.javatech.labs8.exceptions.translatables;

import javax.ejb.ApplicationException;

@ApplicationException
public abstract class TranslatableException extends RuntimeException {
    protected int http;
    protected String message;
    protected String code;

    public int getHttpCode() {
        return http;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public String toJSON() {
        return null;
    }
}
