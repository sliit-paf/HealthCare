package com.project.healthcare.dao;

import com.project.healthcare.model.Appointment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao extends DaoHelper {
    public void saveAppointment(Appointment appointment) throws ClassNotFoundException, SQLException {
        String sql = "insert into appointment values (?,?,?,?,?,?,?,?)";

        PreparedStatement st = dbConnection().prepareStatement(sql);
        st.setInt(1, appointment.getId());
        st.setInt(2, appointment.getPatientId());
        st.setInt(3, appointment.getHospiatlId());
        st.setInt(4, appointment.getClinicId());
        st.setInt(5, appointment.getDocId());
        st.setString(6, appointment.getStartTime());
        st.setString(7, appointment.getEndTime());
        st.setString(8, appointment.getStatus());
        st.executeUpdate();
    }

    public List<Appointment> getAllAppointments() throws ClassNotFoundException, SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "select * from appointment";

        Statement st = dbConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Appointment appointment = new Appointment();
            appointment.setId(rs.getInt(1));
            appointment.setPatientId(rs.getInt(2));
            appointment.setHospiatlId(rs.getInt(3));
            appointment.setClinicId(rs.getInt(4));
            appointment.setDocId(rs.getInt(5));
            appointment.setStartTime(rs.getString(6));
            appointment.setEndTime(rs.getString(7));
            appointment.setStatus(rs.getString(8));
            appointments.add(appointment);
        }

        return appointments;
    }

    public Appointment getAppointment(int id) throws SQLException, ClassNotFoundException {
        String sql = "select * from appointment where id="+id;
        Appointment appointment = new Appointment();

        Statement st = dbConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next()){
            appointment.setId(rs.getInt(1));
            appointment.setPatientId(rs.getInt(2));
            appointment.setHospiatlId(rs.getInt(3));
            appointment.setClinicId(rs.getInt(4));
            appointment.setDocId(rs.getInt(5));
            appointment.setStartTime(rs.getString(6));
            appointment.setEndTime(rs.getString(7));
            appointment.setStatus(rs.getString(8));
        }

        return appointment;
    }

    public void updateAppointment(Appointment appointment) throws SQLException, ClassNotFoundException {
        String sql = "update appointment set patientId=?, hospitalId=?, clinicId=?, docId=?, startTime=?, endTime=?, status=? where id=?";

        PreparedStatement st = dbConnection().prepareStatement(sql);
        st.setInt(1, appointment.getPatientId());
        st.setInt(2, appointment.getHospiatlId());
        st.setInt(3, appointment.getClinicId());
        st.setInt(4, appointment.getDocId());
        st.setString(5, appointment.getStartTime());
        st.setString(6, appointment.getEndTime());
        st.setString(7, appointment.getStatus());
        st.setInt(8, appointment.getId());
        st.executeUpdate();
    }

    public void deleteAppointment(int id) throws SQLException, ClassNotFoundException {
        String sql = "delete from appointment where id=?";

        PreparedStatement st = dbConnection().prepareStatement(sql);
        st.setInt(1, id);
        st.executeUpdate();
    }
}
