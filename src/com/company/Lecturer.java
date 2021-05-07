package com.company;

public class Lecturer {
    String lecturerId;
    String name;
    String password;
    String contact;

    public Lecturer(String lecturerId, String name, String password, String contact) {
        this.lecturerId = lecturerId;
        this.name = name;
        this.password = password;
        this.contact = contact;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return ("Lecturer - " + lecturerId + " - "
                + "Name - " + name + " - "
                + "Password - " + password + " - "
                + "Contact Number - " + contact);
    }
}
