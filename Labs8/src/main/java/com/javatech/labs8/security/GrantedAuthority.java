package com.javatech.labs8.security;

public class GrantedAuthority {
    String authority;

    public GrantedAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
