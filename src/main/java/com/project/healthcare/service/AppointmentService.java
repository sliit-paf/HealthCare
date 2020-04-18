package com.project.healthcare.service;

import com.project.healthcare.dao.AppointmentDao;
import com.project.healthcare.model.Appointment;

import java.sql.SQLException;
import java.util.List;

public class AppointmentService {
    public void createAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
        AppointmentDao appointmentDao = new AppointmentDao();
        appointmentDao.saveAppointment(appointment);
    }

    public List<Appointment> getAllAppointments() throws SQLException, ClassNotFoundException {
        AppointmentDao appointmentDao = new AppointmentDao();
        return appointmentDao.getAllAppointments();
    }

    public Appointment getAppointmentById(int id) throws SQLException, ClassNotFoundException {
        AppointmentDao appointmentDao = new AppointmentDao();
        return appointmentDao.getAppointment(id);
    }

    public void updateAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
        AppointmentDao appointmentDao = new AppointmentDao();
        appointmentDao.updateAppointment(appointment);
    }

    public void deleteAppointment(int id) throws SQLException, ClassNotFoundException {
        AppointmentDao appointmentDao = new AppointmentDao();
        appointmentDao.deleteAppointment(id);
    }
}
