package com.javatech.labs8.controller;

import com.javatech.labs8.annotations.JWTTokenRequired;
import com.javatech.labs8.dtos.AccountDTO;
import com.javatech.labs8.dtos.AccountLoginDTO;
import com.javatech.labs8.dtos.AccountRegisterDTO;
import com.javatech.labs8.entity.Account;
import com.javatech.labs8.exceptions.AccountAlreadyExistsException;
import com.javatech.labs8.exceptions.AccountInvalidCredentialsException;
import com.javatech.labs8.exceptions.AccountNotFoundException;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.service.AccountService;
import com.javatech.labs8.tokens.TokenHandler;
import com.javatech.labs8.utils.ResponseEntityPayload;
import com.javatech.labs8.utils.ResponsePayload;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Path("/users")
@RequestScoped
public class UserController {
    @Inject
    AccountService accountService;

    @GET
    @Path("/users")
    @Produces("application/json")
    public Response getUsers() {
        return null;
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response addWithRole(Account user) {
        return null;
    }

    @POST
    @Path("/authenticate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(AccountLoginDTO user) throws AccountInvalidCredentialsException,AccountNotFoundException {

        Long id = accountService.validate(user);

        String token = TokenHandler.issue(id);

        ResponseEntityPayload<String> payload = new ResponseEntityPayload<String>(
                "SUCCESS",
                "User logged in successfully",
                Collections.singletonList(token)
        );

        return Response
                .status(Response.Status.OK)
                .entity(payload)
                .build();

    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response register(AccountRegisterDTO user) throws AccountAlreadyExistsException {

        accountService.create(user);

        ResponsePayload payload = new ResponsePayload (
                "SUCCESS",
                "ACCOUNT_CREATED",
                "Account successfully created!");

        return Response
                .status(Response.Status.OK)
                .entity(payload)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces("application/json")
    public Response update(@PathParam("id") long id, AccountDTO user) throws AccountNotFoundException {
        return null;
    }

    @DELETE
    @Path("/{id}")
    @JWTTokenRequired(Permissions = {
            Role.ADMIN})
    @Produces("application/json")

    public Response delete(@PathParam("id") long id) {
        return null;
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateRole() {
        return null;
    }
}
