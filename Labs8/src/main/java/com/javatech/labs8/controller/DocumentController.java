package com.javatech.labs8.controller;

import com.javatech.labs8.service.DocumentService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/documents")
@ApplicationScoped
public class DocumentController {

    @Inject
    DocumentService documentService;

    @GET
    @Produces("application/json")
    public Response getDocuments() {
        return null;
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response uploadDocument() {
        return null;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeDocument() {
        return null;
    }

    @POST
    @Path("/{id}/references/{refId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addReferenceToDocument(@PathParam("id") long id, @PathParam("refId") long refId) {
        return null;
    }

    @DELETE
    @Path("/{id}/references/{refId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteReferenceFromDocument(@PathParam("id") long id, @PathParam("refId") long refI) {
        return null;
    }

    @GET
    @Path("/{id}/references")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReferencesFromDocument(@PathParam("id") long id) {
        return null;
    }




}
