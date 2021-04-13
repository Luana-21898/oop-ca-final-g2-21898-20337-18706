package com.company;

public class Admin extends User {

    private Student student;
    private FacultyMember facultyMember;
    private Courses courses;
    private String id;
    private String password;
    private Lecturer lecturer;
    private Fees fees;
    private Grades grades;

    public Admin(String firstName, String lastName, String id, String password) {
        super(firstName, lastName, id, password);
    }


    public Student createStudent(String firstName, String lastName, String id, String password) {

        this.student = new Student(firstName, lastName,id, password);
        return this.student;
    }

    public FacultyMember createFacultyMember(String firstName, String lastName, String id, String password) {

        this.facultyMember = new FacultyMember(firstName, lastName,id, password);
        return this.facultyMember;
    }

    public Courses createCourses(String nameCourse, String nameLecturer) {

        this.courses = new Courses(nameCourse, nameLecturer);
        return this.courses;
    }
}
