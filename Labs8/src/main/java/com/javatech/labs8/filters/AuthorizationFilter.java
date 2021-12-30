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

            JWTTokenRequired JWTContext = method.getAnnotation(JWTTokenRequired.class);
            Role[] permissions =  JWTContext.Permissions();

            Long id = (Long) requestContext.getProperty("account_id");

            checkPermissions(permissions, id);


        }
    }

    private void checkPermissions(Role[] permissions, Long id) throws AccountNotAllowedException {
        List<Role> permissionsList = Arrays.asList(permissions);
        Role userPermission = accountService.getAccountRole(id);

        System.out.println("Trebuie sa gasim permisiunea:" + userPermission);

        if(!permissionsList.contains(userPermission)) {
            throw new AccountNotAllowedException();
        }
    }


}