package com.javatech.labs9.config;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Path("/")
@RequestScoped
public class CallController {

    @Path("/callServiceA")
    @GET
    public Response callServiceA() {
        WebTarget target = ClientBuilder.newClient().target("http://172.17.0.3:8080/labs9/api/v1/users/welcome");
        Response response = target.request().buildGet().invoke();

        System.out.println(response.readEntity(String.class));

        return Response.status(200).build();
    }

}
