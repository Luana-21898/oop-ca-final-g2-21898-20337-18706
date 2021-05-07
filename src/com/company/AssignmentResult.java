package com.company;

public class AssignmentResult {
    String assignmentDetails;
    String studentId;
    String lecturerId;
    String courseId;
    double totalMarks;
    double obtainedMarks;

    public AssignmentResult(String assignmentDetails, String studentId, String lecturerId, String courseId, double totalMarks, double obtainedMarks) {
        this.assignmentDetails = assignmentDetails;
        this.studentId = studentId;
        this.lecturerId = lecturerId;
        this.courseId = courseId;
        this.totalMarks = totalMarks;
        this.obtainedMarks = obtainedMarks;
    }

    @Override
    public String toString() {
        return ("AssignmentResult - " +
                "Assignment Details - " + assignmentDetails + " - " +
                "Student ID - " + studentId + " - " +
                "Lecturer ID - " + lecturerId + " - " +
                "Course ID - " + courseId + " - " +
                "Total Marks - " + totalMarks + " - " +
                "Obtained Marks - " + obtainedMarks);
    }

    public String getAssignmentDetails() {
        return assignmentDetails;
    }

    public void setAssignmentDetails(String assignmentDetails) {
        this.assignmentDetails = assignmentDetails;
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

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(double obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }
}

