package com.example.authapp.activities;

public class dataUser {
    private String id;

    private String name;
    private String city;
    private String message;
    private long date;

    public dataUser() {
    }

    public dataUser(String name, String city, String message, long date) {
        this.name = name;
        this.city = city;
        this.message = message;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getMessage() {
        return message;
    }

    public long getDate() {
        return date;
    }
}
