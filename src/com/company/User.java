package com.company;

public abstract class User {

    public String firstName;
    public String lastName;
    public String id;
    public String password;

    public User(String firstName, String lastName, String id, String password){

        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
    }



}
