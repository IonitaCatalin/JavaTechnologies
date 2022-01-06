package com.javatech.labs9.controller;

import com.javatech.labs9.annotations.JWTTokenRequired;
import com.javatech.labs9.pemissions.Role;
import com.javatech.labs9.repository.DocumentRepository;
import com.javatech.labs9.service.ContestService;

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
