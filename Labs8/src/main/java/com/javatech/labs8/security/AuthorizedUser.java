package com.javatech.labs8.security;

import com.javatech.labs8.entity.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AuthorizedUser extends User {
    public boolean hasPermission(String permission) {
        if (getRole() != null) {
            return getRole().getGrantedAuthorities().stream().anyMatch(it -> it.getAuthority().equals(permission));
        }
        return false;
    }

    public boolean hasRole(String role) {
        if (getRole() != null) {
            return getRole().getGrantedAuthorities().stream().anyMatch(it -> it.getAuthority().equals("ROLE_" + role));
        }
        return false;
    }

}
