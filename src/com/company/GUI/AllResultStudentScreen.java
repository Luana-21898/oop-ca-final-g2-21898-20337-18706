package com.company.GUI;

import com.company.AssignmentResult;
import com.company.DataBase.DbOperations;
import com.company.ExamResult;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AllResultStudentScreen extends JFrame {


    private JPanel panel1;
    private JLabel label;
    private JButton backButton;

    private JList<ExamResult> examList;
    private DefaultListModel<ExamResult> examListModel = new DefaultListModel<>();

    private JList<AssignmentResult> assignmentList;
    private DefaultListModel<AssignmentResult> assignmentListModel = new DefaultListModel<>();

    AllResultStudentScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 100, 900, 530);
        panel1 = new JPanel();
        setVisible(true);
        setContentPane(panel1);
        setResizable(false);
        setLayout(null);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        try {
            DbOperations dbOperations = new DbOperations();
            examListModel = dbOperations.getExamResult("Select * from ExamResult where studentId = '" + LogInScreen.studentId + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            DbOperations dbOperations = new DbOperations();
            assignmentListModel = dbOperations.getAssignmentResult("Select * from AssignmentResult where studentId = '" + LogInScreen.studentId + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        label = new JLabel();
        label.setText("Exams Result");
        label.setBounds(150, 5, 200, 25);
        panel1.add(label);

        examList = new JList<>(examListModel);
        examList.setBounds(35, 50, 350, 400);
        examList.setModel(examListModel);
        panel1.add(examList);

        JScrollPane examScrollPane = new JScrollPane(examList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        examScrollPane.setBounds(examList.getX(), examList.getY(), examList.getWidth(), examList.getHeight());
        panel1.add(examScrollPane);

        JLabel label1 = new JLabel();
        label1.setText("Assignments Result");
        label1.setBounds(600, 5, 200, 25);
        panel1.add(label1);

        assignmentList = new JList<>(assignmentListModel);
        assignmentList.setBounds(500, 50, 350, 400);
        panel1.add(assignmentList);

        JScrollPane assignmentScrollPane = new JScrollPane(assignmentList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        assignmentScrollPane.setBounds(assignmentList.getX(), assignmentList.getY(), assignmentList.getWidth(), assignmentList.getHeight());
        panel1.add(assignmentScrollPane);


        backButton = new JButton("Back");
        backButton.setBounds(400, 455, 90, 30);
        panel1.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StudentMenuScreen();
            }
        });

        setVisible(true);
    }


}
