package com.company;

public class Enrollment {
    String studentId;
    String lecturerId;
    String courseId;
    String classId;

    public Enrollment(String studentId, String lecturerId, String courseId, String classId) {
        this.studentId = studentId;
        this.lecturerId = lecturerId;
        this.courseId = courseId;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return ("Enrollment - "
                + "Student ID - " + studentId + " - "
                + "Lecturer ID - " + lecturerId + " - "
                + "Course ID - " + courseId + " - "
                + "Class ID - " + classId);

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}

