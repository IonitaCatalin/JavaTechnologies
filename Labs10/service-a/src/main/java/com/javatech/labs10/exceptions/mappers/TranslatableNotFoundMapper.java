package com.javatech.labs10.exceptions.mappers;

import com.javatech.labs10.exceptions.translatables.TranslatableNotFoundException;
import com.javatech.labs10.utils.ResponsePayload;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranslatableNotFoundMapper implements ExceptionMapper<TranslatableNotFoundException> {
    @Override
    public Response toResponse(TranslatableNotFoundException e) {
        ResponsePayload payload = new ResponsePayload(
                "FAILURE",
                e.getMessage());

        return Response
                .status(Response.Status.NOT_FOUND.getStatusCode())
                .entity(payload)
                .build();
    }
}
