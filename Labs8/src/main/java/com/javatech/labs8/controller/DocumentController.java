package com.javatech.labs8.controller;

import com.javatech.labs8.annotations.JWTTokenRequired;
import com.javatech.labs8.dtos.DocumentAddAuthorDTO;
import com.javatech.labs8.dtos.DocumentAddDTO;
import com.javatech.labs8.dtos.DocumentAddReferenceDTO;
import com.javatech.labs8.dtos.DocumentDTO;
import com.javatech.labs8.entity.Document;
import com.javatech.labs8.pemissions.Role;
import com.javatech.labs8.service.AccountService;
import com.javatech.labs8.service.DocumentService;
import com.javatech.labs8.utils.ResponseEntityPayload;
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
import java.security.SecureClassLoader;
import java.util.Collections;
import java.util.List;

@Path("/documents")
@ApplicationScoped
public class DocumentController {

    @Inject
    DocumentService documentService;


    @GET
    @Produces("application/json")
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.AUTHOR, Role.REVIEWER})
    public Response getDocuments() {

        List<DocumentDTO> documents = documentService.gets();

        ResponseEntityPayload<DocumentDTO> entity = new ResponseEntityPayload<>(
                "SUCCESS",
                "Documents fetched succesfully",
                documents);

        return Response
                .status(Response.Status.OK)
                .entity(entity)
                .build();
    }

    @GET
    @Path("/{documentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.AUTHOR, Role.REVIEWER})
    public Response getDocument( @PathParam("documentId") Long documentId) {

        DocumentDTO document = documentService.get(documentId);

        ResponseEntityPayload<DocumentDTO> entity = new ResponseEntityPayload<>(
                "SUCCESS",
                "Document fetched successfully",
                Collections.singletonList(document)
        );


        return Response
                .status(Response.Status.OK)
                .entity(entity)
                .build();
    }

    @GET
    @Path("/me")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.AUTHOR, Role.REVIEWER})
    public Response getPersonalDocuments(@Context SecurityContext securityContext) {

        Long id = Long.valueOf(securityContext.getUserPrincipal().getName());
        List<DocumentDTO> document = documentService.getPersonal(id);

        ResponseEntityPayload<DocumentDTO> entity = new ResponseEntityPayload<>(
                "SUCCESS",
                "Document fetched successfully",
                Collections.singletonList(document)
        );


        return Response
                .status(Response.Status.OK)
                .entity(entity)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.AUTHOR, Role.REVIEWER})
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
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.AUTHOR, Role.REVIEWER})
    public Response addAuthorToDocument(@Context SecurityContext securityContext,
                                        @PathParam("docId") Long documentId,
                                        DocumentAddAuthorDTO author) {
        String idAsString = securityContext.getUserPrincipal().getName();
        Long id = Long.valueOf(idAsString);

        documentService.addAuthorToDocument(documentId, author.getAuthorId(), id);

        ResponsePayload payload = new ResponsePayload (
                "SUCCESS",
                "Document's author added successfully!");

        return Response
                .status(Response.Status.CREATED)
                .entity(payload)
                .build();
    }


    @DELETE
    @Path("/{docId}")
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.AUTHOR, Role.REVIEWER})
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
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.AUTHOR, Role.REVIEWER})
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
    @Path("/{id}/references/")
    @Consumes("application/json")
    @Produces("application/json")
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.ADMIN, Role.REVIEWER})
    public Response addReferenceToDocument(@PathParam("id") long documentId, DocumentAddReferenceDTO reference) {
        return null;
    }

    @DELETE
    @Path("/{id}/references/{refId}")
    @Consumes("application/json")
    @Produces("application/json")
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.ADMIN, Role.REVIEWER})
    public Response deleteReferenceFromDocument(@PathParam("id") long id, @PathParam("refId") long refI) {
        return null;
    }

    @GET
    @Path("/{id}/references")
    @Produces(MediaType.APPLICATION_JSON)
    @JWTTokenRequired(Permissions = {Role.AUTHOR, Role.ADMIN, Role.REVIEWER})
    public Response getReferencesFromDocument(@PathParam("id") long id) {
        return null;
    }



}
