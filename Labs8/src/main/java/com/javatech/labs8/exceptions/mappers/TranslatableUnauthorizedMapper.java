package com.javatech.labs8.exceptions.mappers;

import com.javatech.labs8.exceptions.translatables.TranslatableNotFoundException;
import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;
import com.javatech.labs8.utils.ResponsePayload;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranslatableUnauthorizedMapper implements ExceptionMapper<TranslatableUnauthorizedException> {
    @Override
    public Response toResponse(TranslatableUnauthorizedException e) {
        ResponsePayload payload = new ResponsePayload(
                "FAILURE",
                e.getCode(),
                e.getMessage());

        return Response
                .status(Response.Status.NOT_FOUND.getStatusCode())
                .entity(payload)
                .build();
    }
}
