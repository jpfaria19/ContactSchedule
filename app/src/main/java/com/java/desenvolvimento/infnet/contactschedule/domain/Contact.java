package com.java.desenvolvimento.infnet.contactschedule.domain;

public class Contact {

    private String Name;
    private String email;
    private String City;
    private int Phone;



    public Contact(){};
    public Contact(String name, String email, String city, int phone) {
        Name = name;
        this.email = email;
        City = city;
        Phone = phone;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
