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

    JComboBox<String> studentCB;
    JComboBox<String> lecturerCB;
    JComboBox<String> courseCB;
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

        studentCB = new JComboBox<>();
        studentCB.setBounds(50, 60, 150, 25);
        studentCB.setToolTipText("Select student Id");
        setStudentComboBox();
        panel1.add(studentCB);

        courseCB = new JComboBox<>();
        courseCB.setBounds(50, 120, 150, 25);
        courseCB.setToolTipText("Select course Id");
        setCourseComboBox();
        panel1.add(courseCB);

        lecturerCB = new JComboBox<>();
        lecturerCB.setBounds(50, 180, 150, 25);
        lecturerCB.setToolTipText("Select lecturer Id");
        setLecturerComboBox();
        panel1.add(lecturerCB);

        classCB = new JComboBox<>();
        classCB.setBounds(50, 240, 150, 25);
        setClassRoomComboBox();
        classCB.setToolTipText("Select Class Id");
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
                    String courseId = String.valueOf(courseCB.getSelectedItem());
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
                courseCB.addItem(course.getCourseId());
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

