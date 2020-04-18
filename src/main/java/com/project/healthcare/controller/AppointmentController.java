package com.project.healthcare.controller;

import com.project.healthcare.model.Appointment;
import com.project.healthcare.model.Hospital;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AppointmentController implements IAppointmentController{

    List<Hospital> hospitals;

    Connection con = null;

    public AppointmentController(){

        String url = "jdbc:mysql://127.0.0.1:3306/hospital";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<Appointment> getAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "select * from appointment";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Appointment a = new Appointment();
                a.setId(rs.getInt(1));
                a.setPatientId(rs.getInt(2));
                a.setHospiatlId(rs.getInt(3));
                a.setClinicId(rs.getInt(4));
                a.setDocId(rs.getInt(5));
                a.setStartTime(rs.getString(6));
                a.setEndTime(rs.getString(7));
                a.setStatus(rs.getString(8));
                appointments.add(a);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return appointments;
    }

    @Override
    public void createAppointment(Appointment a){
        String sql = "insert into appointment values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, a.getId());
            st.setInt(2, a.getPatientId());
            st.setInt(3, a.getHospiatlId());
            st.setInt(4, a.getClinicId());
            st.setInt(5, a.getDocId());
            st.setString(6, a.getStartTime());
            st.setString(7, a.getEndTime());
            st.setString(8, a.getStatus());
            st.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public Appointment getAppointment(int id) {
        String sql = "select * from appointment where id="+id;
        Appointment a = new Appointment();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                a.setId(rs.getInt(1));
                a.setPatientId(rs.getInt(2));
                a.setHospiatlId(rs.getInt(3));
                a.setClinicId(rs.getInt(4));
                a.setDocId(rs.getInt(5));
                a.setStartTime(rs.getString(6));
                a.setEndTime(rs.getString(7));
                a.setStatus(rs.getString(8));
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return a;
    }

    @Override
    public void updateAppointment(Appointment a) {
        String sql = "update appointment set patientId=?, hospitalId=?, clinicId=?, docId=?, startTime=?, endTime=?, status=? where id=?";

        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, a.getPatientId());
            st.setInt(2, a.getHospiatlId());
            st.setInt(3, a.getClinicId());
            st.setInt(4, a.getDocId());
            st.setString(5, a.getStartTime());
            st.setString(6, a.getEndTime());
            st.setString(7, a.getStatus());
            st.setInt(8, a.getId());
            st.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public String deleteAppointment(int id) {
        String sql = "delete from appointment where id=?";
        String output;
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            output = "Successfully Deleted";
        } catch (SQLException e){
            System.out.println(e);
            output = "Error";
        }
            return output;
    }
}
