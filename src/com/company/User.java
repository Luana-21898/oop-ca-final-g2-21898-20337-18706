package com.company;

//What data is in common among Admin, Student, Faculty Member and Lecturer
public abstract class User {

    public String firstName;
    public String lastName;
    public String address;
    public String numberDoc;
    public String emailAddress;
    public String loginId;
    public String password;
    public String contactNumber;
    public String collegeName;

    public void User(String firstName, String lastName, String address, String numberDoc, String emailAddress, String loginId,
                     String password, String contactNumber, String collegeName){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.numberDoc = numberDoc;
        this.emailAddress = emailAddress;
        this.loginId = loginId;
        this.password = password;
        this.contactNumber = contactNumber;
        this.collegeName = collegeName;
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

    public String getContactNumber () {
        return contactNumber;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getAddress() {
        return address;
    }
}

