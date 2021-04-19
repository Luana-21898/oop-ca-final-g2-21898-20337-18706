package com.company;

public class TimeTable {

    private Course course;
    private String weekDay;
    private String duration;

    public TimeTable (Course course, String weekDay, String duration) {

        this.course = course;
        this.weekDay = weekDay;
        this.duration = duration;
    }

    public Course getCourse() {
        return course;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public String getDuration() {
        return duration;
    }
}
