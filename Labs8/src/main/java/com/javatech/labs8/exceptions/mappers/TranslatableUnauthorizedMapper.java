package com.javatech.labs8.exceptions.mappers;

import com.javatech.labs8.exceptions.translatables.TranslatableUnauthorizedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranslatableUnauthorizedMapper implements ExceptionMapper<TranslatableUnauthorizedException> {
    @Override
    public Response toResponse(TranslatableUnauthorizedException e) {
        return null;
    }
}
