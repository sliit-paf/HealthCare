package com.project.healthcare.controller;

import java.util.ArrayList;
import com.project.healthcare.model.Hospital;

public interface IHospitalController {

    public String createHospital(Hospital h);

    public Hospital getHospital(String hospitalId);

    public ArrayList<Hospital> getHospitals();

    public Hospital updateHospital(String hospitalid, Hospital id);
}
