package com.company;

//What data is in common among Admin, Student, Faculty Member and Lecturer
public abstract class User {

    public String firstName;
    public String lastName;
    public String numberDoc;
    public String emailAddress;
    public String loginId;
    public String password;

    public User(String firstName, String lastName, String numberDoc, String emailAddress, String loginId, String password){

        this.firstName = firstName;
        this.lastName = lastName;
        this.numberDoc = numberDoc;
        this.emailAddress = emailAddress;
        this.loginId = loginId;
        this.password = password;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public String getNumberDoc () {
        return numberDoc;
    }

    public String getEmailAddress () {
        return emailAddress;
    }

    public String getLoginId () {
        return loginId;
    }

    public String getPassword () {
        return password;
    }
}
