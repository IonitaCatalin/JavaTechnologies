package com.javatech.labs8.security;

import com.javatech.labs8.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Authorized extends User {
    public boolean hasPermission(String permission) {
        if (getRole() != null) {
            return getRole().getPermissions().stream().anyMatch(it -> it.getPermission().equals(permission));
        }
        return false;
    }

    public boolean hasRole(String role) {
        if (getRole() != null) {
            return getRole().getPermissions().stream().anyMatch(it -> it.getPermission().equals("ROLE_" + role));
        }
        return false;
    }

}
