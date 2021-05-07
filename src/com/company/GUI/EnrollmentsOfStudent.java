package com.company.GUI;

import com.company.DataBase.DbOperations;
import com.company.Enrollment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EnrollmentsOfStudent extends JFrame {

    private JPanel panel1;
    private JLabel label;
    private JButton backButton;

    private JList<Enrollment> list;
    private DefaultListModel<Enrollment> listModel = new DefaultListModel<>();

    EnrollmentsOfStudent() {
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
            listModel = dbOperations.getEnrollments("Select * from Enrollment where studentId = '" + LogInScreen.studentId + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        label = new JLabel();
        label.setText("Your Enrollments");
        label.setBounds(400, 5, 200, 25);
        panel1.add(label);

        list = new JList<>(listModel);
        list.setBounds(35, 50, 830, 400);

        list.setModel(listModel);
        panel1.add(list);

        JScrollPane scrollPane = new JScrollPane(list,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
        panel1.add(scrollPane);

        backButton = new JButton("Back");
        backButton.setBounds(400,455,90,30);
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

