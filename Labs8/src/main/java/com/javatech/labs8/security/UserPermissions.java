package com.javatech.labs8.security;

public enum UserPermissions {
    USER_READ("user:read"), USER_WRITE("user:write"),
    DOCUMENT_WRITE("document:write"), DOCUMENT_READ("document:read"),
    CONTEST_WRITE("contest:write"), CONTEST_READ("contest:read");
    public String permission;

    UserPermissions(String s) {
        permission = s;
    }
}
