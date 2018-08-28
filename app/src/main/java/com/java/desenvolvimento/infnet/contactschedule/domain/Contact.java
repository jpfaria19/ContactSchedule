package com.java.desenvolvimento.infnet.contactschedule.domain;


import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.util.Date;
import java.util.Map;

public class Contact {

    private String Name;
    private String Password;
    private String Email;
    private int Phone;
    private int CellPhone;
    private String CPF;
    private String City;
    private long timestamp;
    private Map<String, String> MapMoment = ServerValue.TIMESTAMP;


    public Contact() {
    }

    public Contact(String name, String password, String email, int phone, int cellPhone, String cpf, String city) {
        Name = name;
        Password = password;
        Email = email;
        Phone = phone;
        CellPhone = cellPhone;
        CPF = cpf;
        City = city;
    }


    public Map<String, String> getMapMoment(){
        return MapMoment;
    }

    public void setMapMoment(long Moment){
        timestamp = Moment;
    }

    @Exclude
    public Date getMoment(){
        return new Date(timestamp);
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

}
