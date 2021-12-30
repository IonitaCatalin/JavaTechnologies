package com.javatech.labs8.controller;

import com.javatech.labs8.annotations.JWTTokenRequired;
import com.javatech.labs8.dtos.DocumentAddAuthorDTO;
import com.javatech.labs8.dtos.DocumentAddDTO;
import com.javatech.labs8.entity.Document;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.service.AccountService;
import com.javatech.labs8.service.DocumentService;
import com.javatech.labs8.utils.ResponsePayload;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.security.Permissions;
import java.security.Principal;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.ADMIN})
    public Response addDocument(@Context SecurityContext securityContext,DocumentAddDTO document ) {
        String idAsString = securityContext.getUserPrincipal().getName();

        documentService.create(document,Long.valueOf(idAsString));

        ResponsePayload payload = new ResponsePayload (
                "SUCCESS",
                "Document created successfully!");

        return Response
                .status(Response.Status.CREATED)
                .entity(payload)
                .build();

    }

    @POST
    @Path("/{docId}/authors")
    @Produces("application/json")
    public Response addAuthorToDocument(@Context SecurityContext securityContext,
                                        @PathParam("docId") Long documentId,
                                        DocumentAddAuthorDTO author) {
        String idAsString = securityContext.getUserPrincipal().getName();
        Long id = Long.valueOf(idAsString);

        documentService.addAuthorToDocument(documentId, author.getAuthorId(), id);
    }

    @DELETE
    @Path("/{docId}")
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.ADMIN})
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeDocument(@Context SecurityContext securityContext, @PathParam("docId") Long documentId) {
        String idAsString = securityContext.getUserPrincipal().getName();
        Long id = Long.valueOf(idAsString);

        documentService.remove(documentId, id);

        ResponsePayload payload = new ResponsePayload (
                "SUCCESS",
                "Document removed successfully!");

        return Response
                .status(Response.Status.CREATED)
                .entity(payload)
                .build();

    }

    @DELETE
    @Path("/{docId}/authors/{authorId}")
    @Produces("application/json")
    public Response removeAuthorFromDocument(@Context SecurityContext securityContext,
                                             @PathParam("docId") Long documentId,
                                             @PathParam("authorId") Long authorId) {
        String idAsString = securityContext.getUserPrincipal().getName();
        Long id = Long.valueOf(idAsString);

        documentService.removeAuthorFromDocument(documentId, id, authorId);

        ResponsePayload payload = new ResponsePayload (
                "SUCCESS",
                "Document's author removed successfully!");

        return Response
                .status(Response.Status.CREATED)
                .entity(payload)
                .build();
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
