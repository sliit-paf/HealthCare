package com.project.healthcare.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Appointment {
    private int id;
    private int patientId;
    private int hospiatlId;
    private int clinicId;
    private int docId;
    private String startTime;
    private String endTime;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getHospiatlId() {
        return hospiatlId;
    }

    public void setHospiatlId(int hospiatlId) {
        this.hospiatlId = hospiatlId;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", patient ID='" + patientId + '\'' +
                ", hospital ID='" + hospiatlId + '\'' +
                ", clinic ID='" + clinicId + '\'' +
                ", doc ID='" + docId + '\'' +
                ", start time='" + startTime + '\'' +
                ", end time='" + endTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
