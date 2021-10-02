package edu.nyu.cs;

import java.util.Scanner;

public class Contact {
    private int id;
    private String name;
    private String email;
    private String number;
    private String note;


    public Contact(String name, String email, String number, String note, int id) {
        this.name = name;
        this.number = number;
        this.note = note;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
