package com.javatech.labs8.exceptions.mappers;

import com.javatech.labs8.exceptions.translatables.TranslatableConflictException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranslatableConflictMapper implements ExceptionMapper<TranslatableConflictException> {

    @Override
    public Response toResponse(TranslatableConflictException e) {
        return Response.accepted().build();
    }
}
