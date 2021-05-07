package com.company;

public class ExamResult {
    String studentId;
    String lecturerId;
    String courseId;
    String grade;

    public ExamResult(String studentId, String lecturerId, String courseId, String grade) {
        this.studentId = studentId;
        this.lecturerId = lecturerId;
        this.courseId = courseId;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return ("Exam Result - "
                + "Student ID - " + studentId + " - "
                + "Lecturer ID - " + lecturerId + " - "
                + "Course ID - " + courseId + " - "
                + "Grade - " + grade);
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
