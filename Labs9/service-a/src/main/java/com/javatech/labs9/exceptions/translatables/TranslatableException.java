package com.javatech.labs9.exceptions.translatables;


public abstract class TranslatableException extends Exception {
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
