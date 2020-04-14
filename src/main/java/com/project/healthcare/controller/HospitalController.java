package com.project.healthcare.controller;

import com.project.healthcare.model.Hospital;
import java.util.ArrayList;
import java.util.List;

public class HospitalController implements IHospitalController{
    List<Hospital> hospitals;

    public HospitalController(){
        hospitals = new ArrayList<>();
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

        hospitals.add(h1);
        hospitals.add(h2);
    }

    @Override
    public List<Hospital> getHospitals(){
        return hospitals;
    }

    @Override
    public void createHospital(Hospital h) {
        hospitals.add(h);
    }

    @Override
    public Hospital getHospital(int id) {
        Hospital h1 = null;
        for (Hospital h : hospitals){
            if(h.getId()==id)
                return h;
        }
        return null;
    }


    @Override
    public Hospital updateHospital(int id, Hospital new_id) {
        return null;
    }

    @Override
    public String deleteHospital(int id) {
        return null;
    }
}
