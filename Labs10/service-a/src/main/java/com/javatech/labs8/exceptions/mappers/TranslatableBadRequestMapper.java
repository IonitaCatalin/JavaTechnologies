package com.javatech.labs8.exceptions.mappers;

import com.javatech.labs8.exceptions.translatables.TranslatableBadRequestException;
import com.javatech.labs8.utils.ResponsePayload;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranslatableBadRequestMapper implements ExceptionMapper<TranslatableBadRequestException> {
    @Override
    public Response toResponse(TranslatableBadRequestException e) {
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
