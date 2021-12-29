package com.javatech.labs8.exceptions.mappers;

import com.javatech.labs8.exceptions.translatables.TranslatableNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TranslatableNotFoundMapper implements ExceptionMapper<TranslatableNotFoundException> {
    @Override
    public Response toResponse(TranslatableNotFoundException e) {
        return null;
    }
}
