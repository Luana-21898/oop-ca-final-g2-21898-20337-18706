package com.company;


public class Student extends User {

    private final Course course;

    public Student(String firstName, String lastName, String numberDoc,
                   String emailAddress, String loginId, String password, Course course) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.numberDoc = numberDoc;
        this.emailAddress = emailAddress;
        this.loginId = loginId;
        this.password = password;
        this.course = course;
    }
}

