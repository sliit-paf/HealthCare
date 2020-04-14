package com.project.healthcare.resources;

import com.project.healthcare.model.Hospital;

import javax.validation.constraints.Max;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("hospital")
public class HospitalResource {

    @GET
    @Path("id")
    @Produces(MediaType.APPLICATION_XML)
    public List<Hospital> getHospital() {
        System.out.println("getHospital called");
        Hospital h1 = new Hospital();
        h1.setId(1);
        h1.setName("Hemas");
        h1.setType("Eye");
        h1.setDescription("Eye Hospital");
        h1.setAddress("14/B");
        h1.setPhone("078834893");

        Hospital h2 = new Hospital();
        h2.setId(2);
        h2.setName("Cemas");
        h2.setType("Eye");
        h2.setDescription("Eye Hospital");
        h2.setAddress("14/C");
        h2.setPhone("078833893");

        List<Hospital> hospitals = Arrays.asList(h1,h2);
        return hospitals;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "API works Yey!";
    }
}
