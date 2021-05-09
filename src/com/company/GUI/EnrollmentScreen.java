package com.company.GUI;

import com.company.*;
import com.company.DataBase.DbOperations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EnrollmentScreen extends JFrame {

    JPanel panel1;

    JLabel studentText;
    JLabel lecturerText;
    JLabel moduleText;
    JLabel classText;

    JComboBox<String> studentCB;
    JComboBox<String> lecturerCB;
    JComboBox<String> moduleCB;
    JComboBox<String> classCB;

    JButton addButton;
    JButton backButton;

    JList<Enrollment> list;
    DefaultListModel<Enrollment> listModel = new DefaultListModel<>();

    public EnrollmentScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 800, 550);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        setLayout(null);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        try {
            DbOperations dbOperations = new DbOperations();
            listModel = dbOperations.getEnrollments("Select * from Enrollment");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        studentText = new JLabel();
        studentText.setBounds(50, 30, 150, 25);
        studentText.setText("Student ID");
        panel1.add(studentText);

        studentCB = new JComboBox<>();
        studentCB.setBounds(50, 60, 150, 25);
        studentCB.setToolTipText("Select student ID");
        setStudentComboBox();
        panel1.add(studentCB);

        moduleText = new JLabel();
        moduleText.setBounds(50, 90, 150, 25);
        moduleText.setText("Module ID");
        panel1.add(moduleText);

        moduleCB = new JComboBox<>();
        moduleCB.setBounds(50, 120, 150, 25);
        moduleCB.setToolTipText("Select module ID");
        setCourseComboBox();
        panel1.add(moduleCB);

        lecturerText = new JLabel();
        lecturerText.setBounds(50, 150, 150, 25);
        lecturerText.setText("Lecturer ID");
        panel1.add(lecturerText);

        lecturerCB = new JComboBox<>();
        lecturerCB.setBounds(50, 180, 150, 25);
        lecturerCB.setToolTipText("Select Lecturer ID");
        setLecturerComboBox();
        panel1.add(lecturerCB);

        classText = new JLabel();
        classText.setBounds(50, 210, 150, 25);
        classText.setText("Class ID");
        panel1.add(classText);

        classCB = new JComboBox<>();
        classCB.setBounds(50, 240, 150, 25);
        setClassRoomComboBox();
        classCB.setToolTipText("Select Class ID");
        panel1.add(classCB);

        JLabel label = new JLabel();
        label.setText("All Enrollments");
        label.setBounds(500, 10, 200, 25);
        panel1.add(label);


        list = new JList<>(listModel);
        list.setBounds(350, 60, 400, 400);
        panel1.add(list);

        JScrollPane scrollPane = new JScrollPane(list,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
        panel1.add(scrollPane);

        addButton = new JButton("Add");
        addButton.setBounds(50, 360, 150, 30);
        panel1.add(addButton);


        backButton = new JButton("Back");
        backButton.setBounds(640, 470, 100, 30);
        panel1.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String studentId = String.valueOf(studentCB.getSelectedItem());
                    String lecturerId = String.valueOf(lecturerCB.getSelectedItem());
                    String courseId = String.valueOf(moduleCB.getSelectedItem());
                    String classId = String.valueOf(classCB.getSelectedItem());

                    DbOperations dbOperations = new DbOperations();
                    Enrollment enrollment = new Enrollment(
                            studentId, lecturerId, courseId, classId
                    );

                    if (studentId.equals("2018CS1")) {
                        listModel.addElement(enrollment);
                    }

                    dbOperations.addEnrollment(enrollment);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminMenuScreen();
            }
        });

        setVisible(true);
    }


    public void setLecturerComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<Lecturer> lecturers = dbOperations.getLecturers("Select * from Lecturer");

            for (int i = 0; i < lecturers.size(); i++) {
                Lecturer lecturer = lecturers.get(i);
                lecturerCB.addItem(lecturer.getLecturerId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setStudentComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<Student> students = dbOperations.getStudents("Select * from Student");

            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                studentCB.addItem(student.getId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCourseComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<Course> courses = dbOperations.getCourses("Select * from Course");

            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                moduleCB.addItem(course.getCourseId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setClassRoomComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<ClassRoom> classRooms = dbOperations.getClassRooms("Select * from ClassRoom");

            for (int i = 0; i < classRooms.size(); i++) {
                ClassRoom classRoom = classRooms.get(i);
                classCB.addItem(classRoom.getClassRoomId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

