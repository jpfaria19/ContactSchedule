package com.java.desenvolvimento.infnet.contactschedule.domain;

import java.util.Calendar;
import java.util.Date;

public class Contact {

    private String Name;
    private String Email;
    private String City;
    private Date Moment;
    private int Phone;



    public Contact(){};
    public Contact(String name, String email, String city, int phone, Date moment) {
        Name = name;
        Email = email;
        City = city;
        Phone = phone;

        Moment = moment;
        moment = Calendar.getInstance().getTime();
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public Date getMoment() {
        return Moment;
    }

    public void setMoment(Date moment) {
        Moment = moment;
    }
}
