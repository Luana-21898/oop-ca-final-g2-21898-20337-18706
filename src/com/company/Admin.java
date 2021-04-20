package com.company;

public class Admin extends User {

    private Course courses;
    private FacultyMember facultyMember;
    private Student student;
//    private String password;

    public Admin(String firstName, String lastName, String docNumber,
                 String emailAddress, String loginId, String password) {
        super();
        this.password = password;
    }

    //Creating Courses
    public Course createCourse(String nameCourse, String level, String weekDays, String duration, double fees) {

        this.courses = new Course(nameCourse, level, weekDays, duration, fees);
        return this.courses;
    }

    //Creating Faculty Members
    public FacultyMember createFacultyMember(String firstName, String lastName, String docNumber,
                                             String emailAddress, String loginId, String password, String department,
                                             String jobTitle) {

        this.facultyMember = new FacultyMember(firstName, lastName, docNumber, emailAddress, loginId, password,
                department, jobTitle);
        return this.facultyMember;
    }

    //Creating Students
    public Student createStudent(String firstName, String lastName, String numberDoc,
                                 String emailAddress, String loginId, String password, Course course) {

        this.student = new Student(firstName, lastName, numberDoc, emailAddress, loginId, password, course);
        return this.student;
    }

}
