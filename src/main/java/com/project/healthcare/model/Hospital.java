package com.project.healthcare.model;

public class Hospital {
    private int id;
    private String name;
    private String type;
    private String description;
    private String address;
    private int phone;

    //Constructor
    public Hospital(){}
    public Hospital(String name, String type, String description, String address, int phone) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.address = address;
        this.phone = phone;
    }
    //Getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
