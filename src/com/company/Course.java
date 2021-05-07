package com.company;

public class Course {
    String courseId;
    String courseName;
    String forSemester;
    int creditHours;
    String lecturerId;

    public Course(String courseId, String courseName, String forSemester, int creditHours, String lecturerId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.forSemester = forSemester;
        this.creditHours = creditHours;
        this.lecturerId = lecturerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getForSemester() {
        return forSemester;
    }

    public void setForSemester(String forSemester) {
        this.forSemester = forSemester;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    @Override
    public String toString() {
        return ("Course - " + courseId + " - " + courseName + " - "
                + "Semester - " + forSemester + " - "
                + "Hours - " + creditHours + " - "
                + "Lecturer ID - " + lecturerId);
    }
}