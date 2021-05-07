package com.company.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentMenuScreen extends JFrame {
    private JPanel panel1;
    private static JButton resultB;
    private static JButton enrollmentB;
    private static JButton announcementB;
    private static JButton logOutB;


    StudentMenuScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 350, 450);
        panel1 = new JPanel();
        setVisible(true);
        setContentPane(panel1);
        setResizable(false);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);


        resultB = new JButton("Result");
        resultB.setBounds(90, 50, 150, 70);
        panel1.add(resultB);

        enrollmentB = new JButton("Enrollment");
        enrollmentB.setBounds(90, 150, 150, 70);
        panel1.add(enrollmentB);

        announcementB = new JButton("Announcements");
        announcementB.setBounds(90, 250, 150, 70);
        panel1.add(announcementB);

        logOutB = new JButton("Log Out");
        logOutB.setBounds(90, 370, 150, 30);
        panel1.add(logOutB);


        resultB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AllResultStudentScreen();
            }
        });

        enrollmentB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EnrollmentsOfStudent();
            }
        });

        announcementB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AnnouncementsScreenStudent();
            }
        });

        logOutB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInScreen.studentId = null;
                dispose();
                new LogInScreen();
            }
        });

        setVisible(true);
    }


}
