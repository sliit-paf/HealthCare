package com.project.healthcare.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hospital")
public class HospitalResource {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hospital Resource Called";
    }
}
