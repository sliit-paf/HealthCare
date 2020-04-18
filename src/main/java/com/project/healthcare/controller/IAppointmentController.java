package com.project.healthcare.controller;

import com.project.healthcare.model.Appointment;
import com.project.healthcare.model.Hospital;

import java.util.List;

public interface IAppointmentController {

    public void createAppointment(Appointment a);

    public Appointment getAppointment(int id);

    public List<Appointment> getAppointments();

    public void updateAppointment(Appointment a);

    public String deleteAppointment(int id);
}
