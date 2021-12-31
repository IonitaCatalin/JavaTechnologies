package com.javatech.labs8.filters;

import com.javatech.labs8.annotations.JWTTokenRequired;
import com.javatech.labs8.exceptions.AccountNotAllowedException;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.service.AccountService;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@Provider
@JWTTokenRequired
@Priority(Priorities.AUTHORIZATION)
public class AuthorizationFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Inject
    AccountService accountService;


    @Override
    public void filter(ContainerRequestContext requestContext) throws AccountNotAllowedException {

        Method method = resourceInfo.getResourceMethod();
        if( method != null){

            Principal principal = requestContext.getSecurityContext().getUserPrincipal();

            JWTTokenRequired JWTContext = method.getAnnotation(JWTTokenRequired.class);
            Role[] permissions =  JWTContext.Permissions();


            checkPermissions(permissions, Long.valueOf(principal.getName()));

        }
    }

    private void checkPermissions(Role[] permissions, Long id) throws AccountNotAllowedException {
        List<Role> permissionsList = Arrays.asList(permissions);
        System.out.println("Incercam sa gasim permisiunile:" + permissionsList.toString());

        Role userPermission = accountService.getAccountRole(id);

        System.out.println("User-ul curent are permisiunea de:" + userPermission.toString());

        if(!permissionsList.contains(userPermission)) {
            throw new AccountNotAllowedException();
        }
    }


}