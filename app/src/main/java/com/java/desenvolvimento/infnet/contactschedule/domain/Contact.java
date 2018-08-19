package com.java.desenvolvimento.infnet.contactschedule.domain;

import java.util.Calendar;
import java.util.Date;

public class Contact {

    private String Name;
    private String Password;
    private String Email;
    private String Phone;
    private double CellPhone;
    private double CPF;
    private String City;
    private Date Moment;

    public Contact(String name, String password, String email, String phone, double cellPhone, double cpf, String city) {
        Name = name;
        Password = password;
        Email = email;
        Phone = phone;
        CellPhone = cellPhone;
        CPF = cpf;
        City = city;

        this.Moment = Calendar.getInstance().getTime();
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
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
