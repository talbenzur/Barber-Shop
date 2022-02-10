package com.example.authapp.activities;

public class dataUser {
    private String id;

    private String name;
    private String gender;
    private String city;
    private long date;

    public dataUser() {
    }

    public dataUser(String name, String gender, String city, long date) {
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public long getDate() {
        return date;
    }
}
