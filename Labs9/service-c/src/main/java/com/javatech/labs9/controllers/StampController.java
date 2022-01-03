package com.javatech.labs9.controllers;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;

public class StampController {
    @Inject
    @Claim("microservice-value")
    private ClaimValue<String> custom;

    @GET
    @RolesAllowed("protected")
    public String getStampValue() {
        return null;
    }
}
