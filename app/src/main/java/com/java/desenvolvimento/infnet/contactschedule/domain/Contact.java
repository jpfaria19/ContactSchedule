package com.java.desenvolvimento.infnet.contactschedule.domain;

import java.util.Calendar;
import java.util.Date;

public class Contact {

    private String Name;
    private String Email;
    private String City;
    private Date Moment;
    private String Phone;


    public Contact(String name, String email, String city, String phone) {
        Name = name;
        Email = email;
        City = city;
        Phone = phone;

        this.Moment = Calendar.getInstance().getTime();
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Date getMoment() {
        return Moment;
    }

    public void setMoment(Date moment) {
        Moment = moment;
    }
}
