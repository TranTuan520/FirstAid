package com.example.firstaid.model;

public class User {
    private String Name, Email, SDT,
            blood, id;

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
        Email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User() {
    }

    public User(String name, String email, String SDT, String blood, String id) {
        Name = name;
        Email = email;
        this.SDT = SDT;
        this.blood = blood;
        this.id = id;
    }
}
