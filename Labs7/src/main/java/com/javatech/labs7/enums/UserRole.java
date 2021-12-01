package com.javatech.labs7.enums;

public enum UserRole {
    ADMIN("admin"),
    REVIEWER("reviewer"),
    AUTHOR("author");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    static public UserRole toResource(String str) {
        for(UserRole role:UserRole.values()) {
            if(role.role.equalsIgnoreCase(str)) {
                return role;
            }
        }
        return null;
    }


}
