package com.project.healthcare.resources;

import com.project.healthcare.controller.HospitalController;
import com.project.healthcare.model.Hospital;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("hospitals")
public class HospitalResource {

    HospitalController repo = new HospitalController();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Hospital> getHospital() {
        System.out.println("getHospital called");
        return repo.getHospitals();
    }

    @POST
    @Path("hospital")
    public Hospital createHospital(Hospital h){
        System.out.println(h);
        repo.createHospital(h);
        return h;
    }

}
