package com.javatech.labs8.producers;

import com.javatech.labs8.annotations.AuthenticatedAccount;
import com.javatech.labs8.dtos.UserDTO;
import com.javatech.labs8.service.AccountService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class AuthenticatedAccountProducer {
    @Produces
    @RequestScoped
    @AuthenticatedAccount
    private UserDTO authenticatedUser;

    @Inject
    AccountService accountService;

    public void handleAuthenticatedEvent(@Observes @AuthenticatedAccount String username ) {
        this.authenticatedUser = find(username);
    }

    private UserDTO find(String username) {
        return null;
    }

}
