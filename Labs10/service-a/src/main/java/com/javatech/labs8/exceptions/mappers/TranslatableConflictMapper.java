package com.javatech.labs8.exceptions.mappers;

import com.javatech.labs8.exceptions.translatables.TranslatableConflictException;
import com.javatech.labs8.utils.ResponsePayload;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranslatableConflictMapper implements ExceptionMapper<TranslatableConflictException> {

    @Override
    public Response toResponse(TranslatableConflictException e) {
        ResponsePayload payload = new ResponsePayload(
                "FAILURE",
                e.getMessage()
        );

        return Response
                .status(Response.Status.CONFLICT)
                .entity(payload)
                .build();
    }
}
