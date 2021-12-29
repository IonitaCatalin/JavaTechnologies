package com.javatech.labs8.controller;

import com.javatech.labs8.annotations.Secured;
import com.javatech.labs8.dtos.UserDTO;
import com.javatech.labs8.dtos.UserRegisterDTO;
import com.javatech.labs8.entity.Account;
import com.javatech.labs8.exceptions.AccountAlreadyExistsException;
import com.javatech.labs8.exceptions.AccountNotFoundException;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.service.AccountService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
@RequestScoped
public class UserController {
    @Inject
    AccountService accountService;

    @GET
    @Secured
    @Path("/users")
    @Produces("application/json")
    public Response getUsers() {
        return null;
    }

    @POST
    @Secured({Role.ADMIN})
    @Consumes("application/json")
    @Produces("application/json")
    public Response addWithRole(Account user) {
        return null;
    }

    @GET
    @Path("/hello")
    public Response helloFromUser() {
        return null;
    }

    @POST
    @Path("/authenticate")
    @Consumes("application/json")
    @Produces("application/json")
    public Response authenticate(UserDTO user) {
        return null;
    }

    @POST
    @Path("/register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response register(UserRegisterDTO user) throws AccountAlreadyExistsException {
        accountService.create(user);
        return Response.accepted().build();
    }

    @PUT
    @Secured
    @Path("/{id}")
    @Produces("application/json")
    public Response update(@PathParam("id") long id, UserDTO user) throws AccountNotFoundException {
        return null;
    }

    @DELETE
    @Secured
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        return null;
    }

    @PUT
    @Secured({Role.ADMIN})
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateRole() {
        return null;
    }
}
