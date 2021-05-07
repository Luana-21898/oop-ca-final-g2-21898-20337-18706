package com.company.GUI;

import com.company.Course;
import com.company.DataBase.DbOperations;
import com.company.ExamResult;
import com.company.Lecturer;
import com.company.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ResultScreen extends JFrame {

    JPanel panel1;

    JComboBox<String> studentsCB;
    JComboBox<String> gradesCB;
    JComboBox<String> lecturersCB;
    JComboBox<String> coursesCB;

    JButton addButton;
    JButton backButton;

    JList<ExamResult> list;
    DefaultListModel<ExamResult> listModel;
    String[] grades = {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};

    public ResultScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 800, 550);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        setLayout(null);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        DbOperations dbOperations = null;

        try {
            dbOperations = new DbOperations();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        listModel = dbOperations.getExamResult("Select * from ExamResult");

        studentsCB = new JComboBox<>();
        studentsCB.setBounds(50, 60, 150, 25);
        studentsCB.setToolTipText("Enter Student Id");
        setStudentComboBox();
        panel1.add(studentsCB);

        gradesCB = new JComboBox<>(grades);
        gradesCB.setBounds(50, 120, 150, 25);
        gradesCB.setToolTipText("Select grade obtained");
        panel1.add(gradesCB);

        coursesCB = new JComboBox<>();
        coursesCB.setBounds(50, 180, 150, 25);
        coursesCB.setToolTipText("Select course Id");
        setCourseComboBox();
        panel1.add(coursesCB);

        lecturersCB = new JComboBox<>();
        lecturersCB.setBounds(50, 240, 150, 25);
        lecturersCB.setToolTipText("Select lecturer id");
        setLecturerComboBox();
        panel1.add(lecturersCB);

        JLabel label = new JLabel();
        label.setText("Results");
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
        addButton.setBounds(50, 430, 150, 30);
        panel1.add(addButton);


        backButton = new JButton("Back");
        backButton.setBounds(640, 470, 100, 30);
        panel1.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseId = String.valueOf(coursesCB.getSelectedItem());
                String lecturerId = String.valueOf(lecturersCB.getSelectedItem());
                String studentId = String.valueOf(studentsCB.getSelectedItem());
                String grade= String.valueOf(gradesCB.getSelectedItem());

                try {
                    DbOperations dbOperations = new DbOperations();

                    ExamResult result = new ExamResult(studentId,lecturerId,courseId, grade);
                    listModel.addElement(result);
                    dbOperations.addExamResult(result);
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
                lecturersCB.addItem(lecturer.getLecturerId());
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
                studentsCB.addItem(student.getId());
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
                coursesCB.addItem(course.getCourseId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

