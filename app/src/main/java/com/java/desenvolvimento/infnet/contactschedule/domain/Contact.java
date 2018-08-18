package com.java.desenvolvimento.infnet.contactschedule.domain;


import java.util.Date;

public class Contact {

    private String Name;
    private String Password;
    private String Email;
    private double Phone;
    private double CellPhone;
    private double CPF;
    private String City;
    private Date Moment;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    //@Exclude -> Faz com que a senha não seja gravada no database
    public String getPassword() {
        return Password;
    }

    //@Exclude -> Faz com que a senha não seja gravada no database
    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public double getPhone() {
        return Phone;
    }

    public void setPhone(double phone) {
        Phone = phone;
    }

    public double getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(double cellPhone) {
        CellPhone = cellPhone;
    }

    public double getCPF() {
        return CPF;
    }

    public void setCPF(double CPF) {
        this.CPF = CPF;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Date getMoment() {
        return Moment;
    }

    public void setMoment(Date moment) {
        Moment = moment;
    }
}
