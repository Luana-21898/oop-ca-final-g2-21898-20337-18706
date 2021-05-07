package com.company;

public class ClassRoom {
    String classRoomId;

    public ClassRoom(String classRoomId) {
        this.classRoomId = classRoomId;
    }

    @Override
    public String toString() {
        return ("ClassRoom - "
                + "ClassRoom ID - " + classRoomId);
    }

    public String getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(String classRoomId) {
        this.classRoomId = classRoomId;
    }
}
