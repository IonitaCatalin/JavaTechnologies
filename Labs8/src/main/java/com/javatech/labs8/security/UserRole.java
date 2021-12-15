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
    private final Set<Permission> permissions = new HashSet<>();

    UserRole(HashSet<UserPermissions> userPermissions) {
        for (UserPermissions userPermission :
                userPermissions) {
            permissions.add(new Permission(userPermission.permission));
        }
       permissions.add(new Permission("ROLE_" + this.name()));
    }


    UserRole(HashSet<UserRole> userRoles, HashSet<UserPermissions> userPermissions) {
        for (UserRole user :
                userRoles) {
            permissions.addAll(user.permissions);
        }

        for (UserPermissions userPermission :
                userPermissions) {
            permissions.add(new Permission(userPermission.permission));
        }
        permissions.add(new Permission("ROLE_" + this.name()));
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
}
