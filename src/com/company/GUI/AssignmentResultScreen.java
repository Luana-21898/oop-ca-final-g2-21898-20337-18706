package com.company.GUI;

import com.company.AssignmentResult;
import com.company.Course;
import com.company.DataBase.DbOperations;
import com.company.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AssignmentResultScreen extends JFrame {

    JPanel panel1;

    JTextField assignmentDetailsTF;
    JComboBox<String> studentCB;
    JComboBox<String> courseCB;
    JTextField totalMarksTF;
    JTextField obtainedMarksTF;

    JButton addButton;
    JButton backButton;

    JList<AssignmentResult> list;
    DefaultListModel<AssignmentResult> listModel = new DefaultListModel<>();

    public AssignmentResultScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 800, 550);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        setLayout(null);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        try {
            DbOperations dbOperations = new DbOperations();
            listModel = dbOperations.getAssignmentResult("Select * from AssignmentResult where lecturerId = '" + LogInScreen.lecturerId + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        assignmentDetailsTF = new JTextField();
        assignmentDetailsTF.setBounds(50, 60, 150, 25);
        assignmentDetailsTF.setToolTipText("Enter assignment details");
        panel1.add(assignmentDetailsTF);

        studentCB = new JComboBox<>();
        studentCB.setBounds(50, 120, 150, 25);
        studentCB.setToolTipText("Select student id");
        setStudentComboBox();
        panel1.add(studentCB);

        courseCB = new JComboBox<>();
        courseCB.setBounds(50, 180, 150, 25);
        courseCB.setToolTipText("Select course id");
        setCourseComboBox();
        panel1.add(courseCB);

        totalMarksTF = new JTextField();
        totalMarksTF.setBounds(50,240,150,25);
        totalMarksTF.setToolTipText("Enter total marks");
        panel1.add(totalMarksTF);

        obtainedMarksTF = new JTextField();
        obtainedMarksTF.setBounds(50,300,150,25);
        obtainedMarksTF.setToolTipText("Enter obtained marks");
        panel1.add(obtainedMarksTF);


        JLabel label = new JLabel();
        label.setText("Assignments");
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
                try {
                    String studentId = String.valueOf(studentCB.getSelectedItem());
                    String courseId = String.valueOf(courseCB.getSelectedItem());
                    double totalMarks = Double.parseDouble(totalMarksTF.getText().toString());
                    double obtainedMarks = Double.parseDouble(obtainedMarksTF.getText().toString());

                    DbOperations dbOperations = new DbOperations();
                    AssignmentResult result = new AssignmentResult(
                            assignmentDetailsTF.getText().toString(),studentId,LogInScreen.lecturerId,courseId,totalMarks,obtainedMarks
                    );
                    listModel.addElement(result);
                    dbOperations.addAssignmentResult(result);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LecturersMenuScreen();
            }
        });

        setVisible(true);
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


}

