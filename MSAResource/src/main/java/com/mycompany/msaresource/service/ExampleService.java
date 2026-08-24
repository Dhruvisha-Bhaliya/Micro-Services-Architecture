package com.mycompany.msaresource.service;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/example")
public class ExampleService {

    @GET
    @RolesAllowed({"chief","hacker"})
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
         return "Hello, world! of Micro Profile from Trial App";
    }

}
