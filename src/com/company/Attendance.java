package com.company;

public class Attendance {
    String studentId;
    String status;
    String currentDate;
    String courseId;
    String lecturerId;
    String classId;

    public Attendance(String studentId, String status, String currentDate, String courseId, String lecturerId, String classId) {
        this.studentId = studentId;
        this.status = status;
        this.currentDate = currentDate;
        this.courseId = courseId;
        this.lecturerId = lecturerId;
        this.classId = classId;
    }

    @Override
    public String toString() {
        return ("Attendance - " +
                "Student ID - " + studentId + " - " +
                "Status - " + status + " - " +
                "Current Date - " + currentDate + " - " +
                "Course ID - " + courseId + " - " +
                "Lecturer ID - " + lecturerId + " - " +
                "Class ID - " + classId);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}

