package com.project.healthcare.controller;

import java.util.List;

import com.project.healthcare.model.Hospital;

public interface IHospitalController {

    public void createHospital(Hospital h);

    public Hospital getHospital(int id);

    public List<Hospital> getHospitals();

    public Hospital updateHospital(int id, Hospital new_id);

    public String deleteHospital(int id);
}
