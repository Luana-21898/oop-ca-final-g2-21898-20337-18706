package com.company.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {

    private static String dataBaseName;
    final String DB_DATABASE = "vgc";
    final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_DATABASE;
    final String DB_USER = "LuanaHF";
    final String DB_PASSWORD = "12232321";
    private Connection connection;

    public DbConnector() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
//        Statement statement = connection.createStatement();
//
//
//        /* creating student table */
//        statement.execute("CREATE table if not exists Student ( " +
//                "studentId INTEGER NOT NULL AUTO_INCREMENT" +
//                "studentName VARCHAR(100) NOT NULL," +
//                "password VARCHAR(10) NOT NULL," +
//                "contactPhone VARCHAR(20) NOT NULL," +
//                "semester VARCHAR(10) NOT NULL," +
//                "classId INTEGER NOT NULL," +
//                "PRIMARY KEY(studentId) )");
//
//        /*creating Lecturer table */
//        statement.execute("CREATE table if not exists Lecturer ( " +
//                "lecturerId INTEGER NOT NULL AUTO_INCREMENT," +
//                "lecturerName VARCHAR(100) NOT NULL," +
//                "password VARCHAR(10) NOT NULL," +
//                "contactPhone VARCHAR(20) NOT NULL," +
//                "PRIMARY KEY(lecturerId) )");
//
//        /*creating Admin table */
//        statement.execute("CREATE table if not exists Admin ( " +
//                "adminId INTEGER NOT NULL AUTO_INCREMENT," +
//                "adminName VARCHAR(100) NOT NULL," +
//                "password VARCHAR(10) NOT NULL," +
//                "contactPhone VARCHAR(20) NOT NULL," +
//                "PRIMARY KEY(adminId) )");
//
//        /*creating Course table */
//        statement.execute("CREATE table if not exists Course ( " +
//                "courseId INTEGER NOT NULL AUTO_INCREMENT," +
//                "courseName VARCHAR(100) NOT NULL," +
//                "enrollFor VARCHAR(20) NOT NULL," +
//                "creditHours VARCHAR(20) NOT NULL," +
//                "lecturerId INTEGER NOT NULL," +
//                "PRIMARY KEY(courseId)," +
//                "FOREIGN KEY(lecturerId) REFERENCES Lecturer(lecturerId) )");
//
//        /*creating ClassRoom table */
//        statement.execute("CREATE table if not exists ClassRoom ( " +
//                "classRoomId VARCHAR(10) NOT NULL," +
//                "PRIMARY KEY(classRoomId) ) ");
//
//        /*creating Attendance table */
//        statement.execute("CREATE table if not exists Attendance ( " +
//                "id INTEGER PRIMARY KEY," +
//                "studentId INTEGER NOT NULL," +
//                "status VARCHAR(20) NOT NULL," +
//                "currentDate DATE NOT NULL," +
//                "courseId INTEGER NOT NULL," +
//                "lecturerId INTEGER NOT NULL," +
//                "classId INTEGER NOT NULL," +
//                "FOREIGN KEY(courseId) REFERENCES Course(courseId) , " +
//                "FOREIGN KEY(lecturerId) REFERENCES Lecturer(lecturerId) , " +
//                "FOREIGN KEY(studentId) REFERENCES Student(studentId) )");
//
//        /*creating Announcement table */
//        statement.execute("CREATE table if not exists Announcement ( " +
//                "id INTEGER PRIMARY KEY," +
//                "details VARCHAR(20) NOT NULL," +
//                "semester VARCHAR(10) NOT NULL)");
//
//        /*creating Enrollment table */
//        statement.execute("CREATE table if not exists Enrollment ( " +
//                "id INTEGER PRIMARY KEY," +
//                "studentId INTEGER NOT NULL," +
//                "lecturerId INTEGER NOT NULL," +
//                "courseId INTEGER NOT NULL," +
//                "classId INTEGER NOT NULL," +
//                "FOREIGN KEY(courseId) REFERENCES Course(courseId) , " +
//                "FOREIGN KEY(lecturerId) REFERENCES Lecturer(lecturerId) , " +
//                "FOREIGN KEY(studentId) REFERENCES Student(studentId) )");
//
//        /*creating Fee Invoice table */
//        statement.execute("CREATE table if not exists FeeInvoice ( " +
//                "id INTEGER PRIMARY KEY," +
//                "studentId INTEGER NOT NULL," +
//                "fee INTEGER NOT NULL," +
//                "installment INTEGER NOT NULL," +
//                "remaining INTEGER NOT NULL," +
//                "status VARCHAR(20) NOT NULL," +
//                "dueDate DATE NOT NULL," +
//                "FOREIGN KEY(studentId) REFERENCES Student(studentId) )");
//
//        /*creating Exam Result table */
//        statement.execute("CREATE table if not exists ExamResult ( " +
//                "id INTEGER PRIMARY KEY," +
//                "studentId INTEGER NOT NULL," +
//                "lecturerId INTEGER NOT NULL," +
//                "courseId INTEGER NOT NULL," +
//                "grade DOUBLE NOT NULL," +
//                "FOREIGN KEY(studentId) REFERENCES Student(studentId)" +
//                "FOREIGN KEY(lecturerId) REFERENCES Lecturer(lecturerId)" +
//                "FOREIGN KEY(courseId) REFERENCES Course(courseId) )");
//
//        /*creating Assignment Result table */
//        statement.execute("CREATE table if not exists AssignmentResult ( " +
//                "id INTEGER PRIMARY KEY," +
//                "assignmentDetails VARCHAR(20) NOT NULL," +
//                "studentId INTEGER NOT NULL," +
//                "lecturerId INTEGER NOT NULL," +
//                "courseId INTEGER NOT NULL," +
//                "totalMarks DOUBLE NOT NULL," +
//                "obtainedMarks DOUBLE NOT NULL," +
//                "FOREIGN KEY(studentId) REFERENCES Student(studentId)" +
//                "FOREIGN KEY(lecturerId) REFERENCES Lecturer(lecturerId)" +
//                "FOREIGN KEY(courseId) REFERENCES Course(courseId) )");

    }

    public static String getDBName() {
        return dataBaseName;
    }

    public void setDBName(String DBName) {
        this.dataBaseName = DBName;
    }


    public static DbConnector getInstance() throws SQLException {
        return new DbConnector();
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            } else {
                connection.close();
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }
}