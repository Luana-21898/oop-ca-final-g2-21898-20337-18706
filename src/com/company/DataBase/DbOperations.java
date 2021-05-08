package com.company.DataBase;

import com.company.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbOperations {

    DbConnector database = new DbConnector();
    Connection connection = database.getConnection();
    Statement statement = connection.createStatement();

    public DbOperations() throws SQLException {
    }

    public void addStudent(Student student) throws SQLException {
        statement.execute("Insert into Student(studentId,studentName,password,contactPhone,semester,classRoomId)" +
                " VALUES ('" + student.getId() + "' , '" + student.getName() + "' , '" + student.getPassword() + "' , '"
                + student.getContactNo() + "' , '" + student.getSemester() + "' , '" + student.getClassRoomId() + "' " + " )");
    }

    public DefaultListModel<Student> getStudents(String query) {

        Statement statement = null;

        DefaultListModel<Student> model = new DefaultListModel<>();

        Student student = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    student = new Student(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                            resultSet.getString(5), resultSet.getString(6));
                    model.addElement(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public void addLecturer(Lecturer lecturer) throws SQLException {
        statement.execute("Insert into Lecturer(lecturerId,lecturerName,password,contactPhone)" +
                " VALUES ('" + lecturer.getLecturerId() + "' , '" + lecturer.getName() + "' , '" + lecturer.getPassword() + "' , '"
                + lecturer.getContact() + "' " + " )");
    }

    public DefaultListModel<Lecturer> getLecturers(String query) {

        Statement statement = null;

        DefaultListModel<Lecturer> model = new DefaultListModel<>();

        Lecturer lecturer = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    lecturer = new Lecturer(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                    model.addElement(lecturer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public void addCourse(Course course) throws SQLException {
        statement.execute("Insert into Course(courseId,courseName,enrollFor,creditHours,lecturerId)" +
                " VALUES ('" + course.getCourseId() + "' , '" + course.getCourseName() + "' , '" + course.getForSemester() + "' , '"
                + course.getCreditHours() + "' , '" + course.getLecturerId() + "' " + " )");
    }

    public DefaultListModel<Course> getCourses(String query) {

        Statement statement = null;

        DefaultListModel<Course> model = new DefaultListModel<>();

        Course course = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    course = new Course(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), Integer.parseInt(resultSet.getString(4)), resultSet.getString(5));
                    model.addElement(course);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public void addExamResult(ExamResult result) throws SQLException {
        statement.execute("Insert into ExamResult(studentId,lecturerId,courseId,grade)" +
                " VALUES ('" + result.getStudentId() + "' , '" + result.getLecturerId() + "' , '" + result.getCourseId() + "' , '"
                + result.getGrade() + "' " + " )");
    }

    public DefaultListModel<ExamResult> getExamResult(String query) {

        Statement statement = null;

        DefaultListModel<ExamResult> model = new DefaultListModel<>();

        ExamResult result = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    result = new ExamResult(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                    model.addElement(result);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public void addAssignmentResult(AssignmentResult result) throws SQLException {
        statement.execute("Insert into AssignmentResult(assignmentDetails,studentId,lecturerId,courseId,totalMarks,obtainedMarks)" +
                " VALUES ('" + result.getAssignmentDetails() + "' , '" + result.getStudentId() + "' , '" + result.getLecturerId() + "' , '"
                + result.getCourseId() + "' , '" + result.getTotalMarks() + "' , '" + result.getObtainedMarks() + "'" + " )");
    }

    public DefaultListModel<AssignmentResult> getAssignmentResult(String query) {

        Statement statement = null;

        DefaultListModel<AssignmentResult> model = new DefaultListModel<>();

        AssignmentResult result = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    result = new AssignmentResult(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                            Double.parseDouble(resultSet.getString(6)), Double.parseDouble(resultSet.getString(7)));
                    model.addElement(result);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public DefaultListModel<Enrollment> getEnrollments(String query) {

        Statement statement = null;

        DefaultListModel<Enrollment> model = new DefaultListModel<>();

        Enrollment enrollment = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    enrollment = new Enrollment(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                    model.addElement(enrollment);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public void addEnrollment(Enrollment enrollment) throws SQLException {
        statement.execute("Insert into Enrollment(studentId,lecturerId,courseId,classId)" +
                " VALUES ('" + enrollment.getStudentId() + "' , '" + enrollment.getLecturerId() + "' , '" + enrollment.getCourseId() + "' , '"
                + enrollment.getClassId() + "'" + " )");
    }

    public void addAttendance(Attendance attendance) throws SQLException {
        statement.execute("Insert into Attendance(studentId,status,currentDate,courseId,lecturerId,classId)" +
                " VALUES ('" + attendance.getStudentId() + "' , '" + attendance.getStatus() + "' , '" + attendance.getCurrentDate() + "' , '"
                + attendance.getCourseId() + "' , '" + attendance.getLecturerId() + "' , '" + attendance.getClassId() + "'" + " )");
    }

    public DefaultListModel<Attendance> getAttendance(String query) {

        Statement statement = null;

        DefaultListModel<Attendance> model = new DefaultListModel<>();

        Attendance attendance = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    attendance = new Attendance(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                            resultSet.getString(6), resultSet.getString(7));
                    model.addElement(attendance);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public void addClassRoom(ClassRoom classRoom) throws SQLException {
        statement.execute("Insert into ClassRoom(classRoomId)" +
                " VALUES ('" + classRoom.getClassRoomId() + "'" + " )");
    }

    public DefaultListModel<ClassRoom> getClassRooms(String query) {

        Statement statement = null;

        DefaultListModel<ClassRoom> model = new DefaultListModel<>();

        ClassRoom classRoom = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    classRoom = new ClassRoom(resultSet.getString(1));
                    model.addElement(classRoom);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public DefaultListModel<FeeInvoice> getInvoices(String query) {

        Statement statement = null;

        DefaultListModel<FeeInvoice> model = new DefaultListModel<>();

        FeeInvoice invoice = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    invoice = new FeeInvoice(resultSet.getString(2), resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getString(6), resultSet.getString(7));
                    model.addElement(invoice);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }

    public int isAuthorized(String query) {

        Statement statement = null;

        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        int count = 0;
        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public void addInvoice(FeeInvoice invoice) throws SQLException {
        statement.execute("Insert into FeeInvoice(studentId,fee,installment,remaining,status,dueDate)" +
                " VALUES ('" + invoice.getStudentId() + "' , '" + invoice.getFee() + "' , '" + invoice.getInstallment() + "' , '"
                + invoice.getRemaining() + "' , '" + invoice.getStatus() + "' , '" + invoice.getDueDate() + " ' " + " )");
    }

    public void addAdmin(String id, String name, String password, String contactNo) throws SQLException {
        statement.execute("Insert into Admin(adminId,adminName,password,contactPhone)" +
                " VALUES ('" + id + "' , '" + name + "' , '" + password + "' , '"
                + contactNo + " ' " + " )");
    }


    public void addAnnouncement(String details, String semester) throws SQLException {
        statement.execute("Insert into Announcement(details,semester)" +
                " VALUES ('" + details + "' , '" + semester + "'" + " )");
    }

    public DefaultListModel<String> getAnnouncements(String query) {

        Statement statement = null;
        DefaultListModel<String> model = new DefaultListModel<>();
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) {
                    break;
                } else {
                    String announcement = resultSet.getString(2) + " for semester : " + resultSet.getString(3);
                    model.addElement(announcement);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return model;
    }


}

