package com.company;


public class Admin extends User {

    private Student student;
    private FacultyMember facultyMember;
    private Course courses;
    private String password;
//    private Lecturer lecturer;
//    private Fees fees;
//    private Grades grades;

    public Admin(String firstName, String lastName, String numberDoc, String emailAddress,
                 String loginId, String password) {

        this.password = password;
    }


    //Creating Students
    public Student createStudent(String firstName, String lastName, String numberDoc,
                                 String emailAddress, String loginId, String password, Course course) {

        this.student = new Student(firstName, lastName, numberDoc, emailAddress, loginId, password, course);
        return this.student;
    }


    //Creating Faculty Members
    public FacultyMember createFacultyMember(String firstName, String lastName, String numberDoc,
                                             String emailAddress, String loginId, String password, Course course) {

        this.facultyMember = new FacultyMember(firstName, lastName, numberDoc, emailAddress, loginId, password, course);
        return this.facultyMember;
    }


    //Creating Courses
    public Course createCourse(String nameCourse, String facultyMember, String weekDays, String duration) {

        this.courses = new Course(nameCourse, facultyMember, weekDays, duration);
        return this.courses;
    }

//    public String getPassword() {
//        return this.password;
//    }
}
