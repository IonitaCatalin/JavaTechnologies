package com.javatech.labs7.enums;

public enum AccountRoleType {
    ADMIN("admin"),
    REVIEWER("reviewer"),
    AUTHOR("author");

    private String role;

    AccountRoleType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    static public AccountRoleType toRole(String str) {
        for(AccountRoleType role: AccountRoleType.values()) {
            if(role.role.equalsIgnoreCase(str)) {
                return role;
            }
        }
        return null;
    }

}
