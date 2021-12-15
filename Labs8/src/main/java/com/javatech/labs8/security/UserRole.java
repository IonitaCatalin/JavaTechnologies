package com.javatech.labs8.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public enum UserRole {
    REVIEWER(new HashSet<>(Arrays.asList(UserPermissions.DOCUMENT_READ))),
    AUTHOR(new HashSet<>(Arrays.asList(UserPermissions.DOCUMENT_WRITE))),
    ADMIN(new HashSet<>(Arrays.asList(AUTHOR, REVIEWER)), new HashSet<>(Arrays.asList(UserPermissions.USER_READ, UserPermissions.USER_WRITE, UserPermissions.CONTEST_READ, UserPermissions.CONTEST_WRITE)));


    private static final Random RANDOM = new Random();
    private static final int SIZE = values().length;
    private final Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

    UserRole(HashSet<UserPermissions> userPermissions) {
        for (UserPermissions userPermission :
                userPermissions) {
            grantedAuthorities.add(new GrantedAuthority(userPermission.permission));
        }
        grantedAuthorities.add(new GrantedAuthority("ROLE_" + this.name()));
    }


    UserRole(HashSet<UserRole> userRoles, HashSet<UserPermissions> userPermissions) {
        for (UserRole user :
                userRoles) {
            grantedAuthorities.addAll(user.grantedAuthorities);
        }

        for (UserPermissions userPermission :
                userPermissions) {
            grantedAuthorities.add(new GrantedAuthority(userPermission.permission));
        }
        grantedAuthorities.add(new GrantedAuthority("ROLE_" + this.name()));
    }

    public static UserRole randomUserRole() {
        return values()[RANDOM.nextInt(SIZE)];
    }

    public Set<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }
}
