package com.company;

public class Student {
    String id;
    String name;
    String password;
    String contactNo;
    String semester;
    String classRoomId;

    public Student(String id, String name, String password, String contactNo, String semester, String classRoomId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.contactNo = contactNo;
        this.semester = semester;
        this.classRoomId = classRoomId;
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public void setClassId(String classId) {
        this.classRoomId = classRoomId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return ("Student - "
                + "ID - " + id + " - "
                + "Name - " + name + " - "
                + "Password - " + password + " - "
                + "Contact No - " + contactNo + " - "
                + "Semester - " + semester + " - "
                + "Class ID - " + classRoomId);
    }
}
