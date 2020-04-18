package com.project.healthcare.resources;

import com.project.healthcare.model.Appointment;
import com.project.healthcare.service.AppointmentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("appointments")
public class AppointmentResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Appointment> getAppointments() {
        System.out.println("get Appointments called");
        AppointmentService appointmentService = new AppointmentService();
        List<Appointment> appointments = new ArrayList<>();
        try {
           appointments = appointmentService.getAllAppointments();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @GET
    @Path("table")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAppointmentsTable() {
        System.out.println("getAppointments table called");
        String output = "<table border=\"1\"><tr><th>ID</th><th>Patient ID</th><th>Hospital ID</th><th>Clinic ID</th><th>Doc ID</th><th>Start Time</th><th>End Time</th><th>Status</th></tr>";
        AppointmentService appointmentService = new AppointmentService();
        List<Appointment> lsits = null;
        try {
            lsits = appointmentService.getAllAppointments();

            for (Appointment a: lsits
            ) {
                String id = Integer.toString(a.getId());
                String patientId = Integer.toString(a.getPatientId());
                String hospitalId = Integer.toString(a.getHospiatlId());
                String clinicId = Integer.toString(a.getClinicId());
                String docId = Integer.toString(a.getDocId());
                String startTime = a.getStartTime();
                String endTime = a.getEndTime();
                String status = a.getStatus();
                output += "<tr><td>" + id + "</td>";
                output += "<td>" + patientId + "</td>";
                output += "<td>" + hospitalId + "</td>";
                output += "<td>" + clinicId + "</td>";
                output += "<td>" + docId + "</td>";
                output += "<td>" + startTime + "</td></tr>";
                output += "<td>" + endTime + "</td></tr>";
                output += "<td>" + status + "</td></tr>";
            }
            output += "</table>";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return output;
    }



    @GET
    @Path("appointment/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Appointment getAppointment(@PathParam("id") int id) {
        System.out.println("getAppointment by ID called");
        AppointmentService appointmentService = new AppointmentService();
        Appointment appointment = new Appointment();
        try {
            appointment =  appointmentService.getAppointmentById(id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return appointment;
    }

    @POST
    @Path("appointment")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Appointment createAppointment(Appointment appointment){
        AppointmentService appointmentService = new AppointmentService();
        try {
            appointmentService.createAppointment(appointment);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return appointment;
    }

    @POST
    @Path("form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createAppointmentForm(@FormParam("id") int id,
                                     @FormParam("patientId") int patientId,
                                     @FormParam("hospitalId") int hospitalId,
                                     @FormParam("clinicId") int clinicId,
                                     @FormParam("docId") int docId,
                                     @FormParam("startTime") String startTime,
                                        @FormParam("endTime") String endTime,
                                        @FormParam("status") String status
                                       ){

        Appointment appointment = new Appointment();
        appointment.setPatientId(patientId);
        appointment.setHospiatlId(hospitalId);
        appointment.setClinicId(clinicId);
        appointment.setDocId(docId);
        appointment.setStartTime(startTime);
        appointment.setEndTime(endTime);
        appointment.setStatus(status);
        appointment.setId(id);

        AppointmentService appointmentService = new AppointmentService();
        String result;
        try {
            appointmentService.createAppointment(appointment);
            result = "Success";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            result ="Fail";
        }

        return result;
    }

    @PUT
    @Path("form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateHospitalForm(@FormParam("id") int id,
                                     @FormParam("patientId") int patientId,
                                     @FormParam("hospitalId") int hospitalId,
                                     @FormParam("clinicId") int clinicId,
                                     @FormParam("docId") int docId,
                                     @FormParam("startTime") String startTime,
                                     @FormParam("endTime") String endTime,
                                     @FormParam("status") String status
    ){
        Appointment a = new Appointment();
        AppointmentService appointmentService = new AppointmentService();
        a.setId(id);
        a.setDocId(docId);
        a.setClinicId(clinicId);
        a.setHospiatlId(hospitalId);
        a.setPatientId(patientId);
        a.setStartTime(startTime);
        a.setEndTime(endTime);
        a.setStatus(status);

        String result;

        try {
            appointmentService.updateAppointment(a);
            result = "Success";
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
            result = "Fail";
        }

        return result;
    }

    @PUT
    @Path("appointment")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Appointment updateAppointment(Appointment appointment){
        AppointmentService appointmentService = new AppointmentService();
        try {
            appointmentService.updateAppointment(appointment);
            return appointment;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @DELETE
    @Path("appointment/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteAppointment(@PathParam("id") int id){
        AppointmentService appointmentService = new AppointmentService();
        try {
            appointmentService.deleteAppointment(id);
            return "Success";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
