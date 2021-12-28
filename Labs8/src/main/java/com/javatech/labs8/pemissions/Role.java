package com.javatech.labs8.pemissions;

public enum Role {
    REVIEWER("REVIEWER"),
    AUTHOR("AUTHOR"),
    ADMIN("ADMIN");

    String role;

    Role(String reviewer) {
        this.role = reviewer;
    }
}
