package com.spring.restws.model;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("EmployeeFilter")
public class Employee {
    private String id;
    private String name;
    private String pwd;
    private String emailId;
    private String phone;
    private String address;

    public Employee(String id, String name, String pwd, String emailId, String phone, String address) {
        super();
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.emailId = emailId;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
