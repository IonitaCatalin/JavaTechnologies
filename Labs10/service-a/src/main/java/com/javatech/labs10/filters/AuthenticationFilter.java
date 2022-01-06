package com.javatech.labs10.filters;

import com.javatech.labs10.annotations.JWTTokenRequired;
import com.javatech.labs10.exceptions.AccountInvalidTokenException;
import com.javatech.labs10.exceptions.AuthorizationMissingTokenException;
import com.javatech.labs10.tokens.TokenHandler;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.security.Principal;

@Provider
@JWTTokenRequired
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {


    private static final String AUTHENTICATION_SCHEME = "Bearer";

    @Override
    public void filter(ContainerRequestContext requestContext)  {

        String authorizationHeader =
                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (!isTokenBasedAuthentication(authorizationHeader)) {
            try {
                throw new AuthorizationMissingTokenException();
            } catch (AuthorizationMissingTokenException e) {
                e.printStackTrace();
            }
        }

        String token = authorizationHeader
                .substring(AUTHENTICATION_SCHEME.length()).trim();

        try {
            validateToken(token, requestContext);
        } catch (AccountInvalidTokenException e) {
            e.printStackTrace();
        }
    }

    private boolean isTokenBasedAuthentication(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }


    private void validateToken(String token, ContainerRequestContext context) throws AccountInvalidTokenException {
        Long id = TokenHandler.validate(token);

        context.setProperty("account_id",id);

        context.setSecurityContext(new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
                return () -> String.valueOf(id);
            }

            @Override
            public boolean isUserInRole(String s) {
                return false;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public String getAuthenticationScheme() {
                return null;
            }

        });

    }
}