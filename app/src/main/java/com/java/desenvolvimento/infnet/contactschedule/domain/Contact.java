package com.java.desenvolvimento.infnet.contactschedule.domain;


import android.os.Build;
import android.support.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Contact {

    private String Name;
    private String Password;
    private String Email;
    private int Phone;
    private int CellPhone;
    private int CPF;
    private String City;
    private LocalDateTime Moment;

    public Contact() {
    }


    public Contact(String name, String password, String email, int phone, int cellPhone, int cpf, String city) {
        Name = name;
        Password = password;
        Email = email;
        Phone = phone;
        CellPhone = cellPhone;
        CPF = cpf;
        City = city;
    }

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

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(int cellPhone) {
        CellPhone = cellPhone;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public LocalDateTime getMoment() {
        return Moment;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setMoment(LocalDateTime moment) {
        Moment = moment;
    }
}
