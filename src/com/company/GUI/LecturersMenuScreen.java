package com.company.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LecturersMenuScreen extends JFrame {

    private JPanel panel1;
    private static JButton gradeB;
    private static JButton attendanceB;
    private static JButton detailsB;
    private static JButton logOutB;
    private static JButton announcementB;


    LecturersMenuScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 350, 500);
        panel1 = new JPanel();
        setVisible(true);
        setContentPane(panel1);
        setResizable(false);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);


        gradeB = new JButton("Assignments Result");
        gradeB.setBounds(90, 50, 150, 70);
        panel1.add(gradeB);

        attendanceB = new JButton("Attendance");
        attendanceB.setBounds(90, 150, 150, 70);
        panel1.add(attendanceB);

        detailsB = new JButton("Student's Details");
        detailsB.setBounds(90, 250, 150, 70);
        panel1.add(detailsB);

        announcementB = new JButton("Announcements");
        announcementB.setBounds(90, 350, 150, 30);
        panel1.add(announcementB);


        logOutB = new JButton("Log Out");
        logOutB.setBounds(90, 420, 150, 30);
        panel1.add(logOutB);


        gradeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AssignmentResultScreen();
            }
        });

        attendanceB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AttendanceScreen();
            }
        });

        detailsB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StudentsDetailsScreen();
            }
        });

        announcementB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AnnouncementScreen();
            }
        });

        logOutB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInScreen.lecturerId = null;
                dispose();
                new LogInScreen();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LecturersMenuScreen();
    }

}


