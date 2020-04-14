package com.project.healthcare.resources;

import com.project.healthcare.controller.HospitalController;
import com.project.healthcare.model.Hospital;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("hospitals")
public class HospitalResource {

    HospitalController repo = new HospitalController();

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Hospital> getHospitals() {
        System.out.println("getHospitals called");
        return repo.getHospitals();
    }

    @GET
    @Path("hospital/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Hospital getHospital(@PathParam("id") int id) {
        System.out.println("getHospital called");
        return repo.getHospital(id);
    }

    @POST
    @Path("hospital")
    public Hospital createHospital(Hospital h){
        System.out.println(h);
        repo.createHospital(h);
        return h;
    }
}
