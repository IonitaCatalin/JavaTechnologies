package com.javatech.labs8.filters;

import com.javatech.labs8.annotations.JWTTokenRequired;
import com.javatech.labs8.exceptions.AccountInvalidTokenException;
import com.javatech.labs8.exceptions.AuthorizationMissingTokenException;
import com.javatech.labs8.tokens.TokenHandler;

import javax.annotation.Priority;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
@JWTTokenRequired
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {


    private static final String AUTHENTICATION_SCHEME = "Bearer";

    @Override
    public void filter(ContainerRequestContext requestContext) throws AuthorizationMissingTokenException {

        String authorizationHeader =
                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (!isTokenBasedAuthentication(authorizationHeader)) {
            throw new AuthorizationMissingTokenException();
        }

        String token = authorizationHeader
                .substring(AUTHENTICATION_SCHEME.length()).trim();

        validateToken(token, requestContext);
    }

    private boolean isTokenBasedAuthentication(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }


    private void validateToken(String token, ContainerRequestContext context) throws AccountInvalidTokenException {
        Long id = TokenHandler.validate(token);

        context.setProperty("account_id",id);

    }
}