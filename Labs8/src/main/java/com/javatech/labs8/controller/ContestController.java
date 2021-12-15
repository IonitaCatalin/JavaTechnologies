package com.javatech.labs8.controller;

import com.javatech.labs8.repository.DocumentRepository;
import com.javatech.labs8.service.ContestService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    public Response getContests() {

        return Response.ok(documentRepository.getEntities()).build();
    }

}
