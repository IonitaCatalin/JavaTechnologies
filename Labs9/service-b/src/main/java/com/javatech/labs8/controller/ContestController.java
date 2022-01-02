package com.javatech.labs8.controller;

import com.javatech.labs8.annotations.JWTTokenRequired;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.repository.DocumentRepository;
import com.javatech.labs8.service.ContestService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/contests")
@ApplicationScoped
public class ContestController {

    @Inject
    ContestService contestService;

    @Inject
    DocumentRepository documentRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.ADMIN,Role.AUTHOR})
    public Response getContests() {

       return null;
    }

    @GET
    @Path("/{contestId}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.REVIEWER})
    public Response getContest() {
        return null;
    }



    @DELETE
    @Path("/{contestId}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.ADMIN})
    public Response deleteContest() {
        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.ADMIN})
    public Response createContest() {
        return null;
    }

    @PUT
    @Path("/{contestId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.ADMIN})
    public Response changeContestStatus(){
        return null;
    }


}
