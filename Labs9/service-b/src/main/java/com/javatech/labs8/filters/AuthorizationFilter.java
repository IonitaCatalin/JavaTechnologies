package com.javatech.labs8.filters;

import com.javatech.labs8.annotations.JWTTokenRequired;
import com.javatech.labs8.exceptions.RequestNotAllowedException;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.repository.AccountRepository;

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
    AccountRepository accountRepository;


    @Override
    public void filter(ContainerRequestContext requestContext) {

        Method method = resourceInfo.getResourceMethod();
        if( method != null){

            Principal principal = requestContext.getSecurityContext().getUserPrincipal();

            JWTTokenRequired JWTContext = method.getAnnotation(JWTTokenRequired.class);
            Role[] permissions =  JWTContext.Permissions();


            checkPermissions(permissions, Long.valueOf(principal.getName()));

        }
    }

    private void checkPermissions(Role[] permissions, Long id) {
        List<Role> permissionsList = Arrays.asList(permissions);

        Role userPermission = accountRepository.getUserRole(id);

        if(!permissionsList.contains(userPermission)) {
            throw new RequestNotAllowedException();
        }
    }


}