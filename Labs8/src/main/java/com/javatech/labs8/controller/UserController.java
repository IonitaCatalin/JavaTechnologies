package com.javatech.labs8.controller;

import com.javatech.labs8.entity.User;
import com.javatech.labs8.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@ApplicationScoped
public class UserController {
    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok(userRepository.getEntities()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUserWithRole(User user) {
//        try {
//            user = userRepository.save(user);
//            return Response.status(Response.Status.CREATED).entity(user).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.BAD_REQUEST).build();
//        }
        return null;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser() {
        return null;
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") long id, User user) {
//        if (userRepository.findById(User.class, id) == null)
//            return Response.noContent().build();
//        user.setId(id);
//        user = userRepository.save(user);
//        return Response.status(Response.Status.OK).entity(user).build();
        return null;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") long id) {
//        if (userRepository.deleteById(User.class, id)) {
//            return Response.ok().entity("User deleted").build();
//        }
//        return Response.noContent().build();
        return null;
    }
}
