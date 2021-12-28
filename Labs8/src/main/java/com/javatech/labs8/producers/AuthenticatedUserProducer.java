package com.javatech.labs8.producers;

import com.javatech.labs8.annotations.AuthenticatedUser;
import com.javatech.labs8.dtos.UserDTO;
import com.javatech.labs8.entity.User;
import com.javatech.labs8.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class AuthenticatedUserProducer {
    @Produces
    @RequestScoped
    @AuthenticatedUser
    private User authenticatedUser;

    @Inject
    UserService userService;

    public void handleAuthenticatedEvent(@Observes @AuthenticatedUser UserDTO user ) {
        this.authenticatedUser = find(user);
    }

    private User find(UserDTO user) {
        return null;
    }

}
