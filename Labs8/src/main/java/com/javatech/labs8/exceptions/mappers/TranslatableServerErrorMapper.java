package com.javatech.labs8.exceptions.mappers;

import com.javatech.labs8.exceptions.translatables.TranslatableServerErrorException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class TranslatableServerErrorMapper implements ExceptionMapper<TranslatableServerErrorException> {
    @Override
    public Response toResponse(TranslatableServerErrorException e) {
        return null;
    }
}
