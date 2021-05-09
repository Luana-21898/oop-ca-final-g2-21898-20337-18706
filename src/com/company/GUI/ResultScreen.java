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

    JLabel studentText;
    JLabel gradesText;
    JLabel lecturerText;
    JLabel moduleText;

    JComboBox<String> studentsCB;
    JComboBox<String> gradesCB;
    JComboBox<String> lecturersCB;
    JComboBox<String> modulesCB;

    JButton addButton;
    JButton backButton;

    JList<ExamResult> list;
    DefaultListModel<ExamResult> listModel;
    String[] grades = {"A","B","C","D","E","F"};

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

        studentText = new JLabel();
        studentText.setBounds(50, 30, 150, 25);
        studentText.setText("Student ID");
        panel1.add(studentText);

        studentsCB = new JComboBox<>();
        studentsCB.setBounds(50, 60, 150, 25);
        studentsCB.setToolTipText("Enter Student ID");
        setStudentComboBox();
        panel1.add(studentsCB);

        gradesText = new JLabel();
        gradesText.setBounds(50, 90, 150, 25);
        gradesText.setText("Grade");
        panel1.add(gradesText);

        gradesCB = new JComboBox<>(grades);
        gradesCB.setBounds(50, 120, 150, 25);
        gradesCB.setToolTipText("Select grade obtained");
        panel1.add(gradesCB);

        moduleText = new JLabel();
        moduleText.setBounds(50, 150, 150, 25);
        moduleText.setText("Module ID");
        panel1.add(moduleText);

        modulesCB = new JComboBox<>();
        modulesCB.setBounds(50, 180, 150, 25);
        modulesCB.setToolTipText("Select module ID");
        setCourseComboBox();
        panel1.add(modulesCB);

        lecturerText = new JLabel();
        lecturerText.setBounds(50, 210, 150, 25);
        lecturerText.setText("Lecturer ID");
        panel1.add(lecturerText);

        lecturersCB = new JComboBox<>();
        lecturersCB.setBounds(50, 240, 150, 25);
        lecturersCB.setToolTipText("Select Lecturer ID");
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
                String courseId = String.valueOf(modulesCB.getSelectedItem());
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
                modulesCB.addItem(course.getCourseId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

