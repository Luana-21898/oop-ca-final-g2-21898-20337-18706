package com.company.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class AdminMenuScreen extends JFrame {

        private static JLabel adminTitle;

        JPanel panel1;
        JButton courseButton;
        JButton lecturerButton;
        JButton studentButton;
        JButton feeButton;
        JButton academicButton;
        JButton examsButton;
        JButton logOutButton;
        JButton enrollStudentB;
        JButton classesStudentB;


        public AdminMenuScreen() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(250, 150, 800, 500);
            panel1 = new JPanel();
            setContentPane(panel1);
            setResizable(false);
            setLayout(null);
            panel1.setBorder(new EmptyBorder(5, 5, 5, 5));

            adminTitle = new JLabel("ADMIN MENU SCREEN");
            adminTitle.setBounds(40, 10, 200, 25);
            panel1.add(adminTitle);


            courseButton = new JButton("Register Course");
            courseButton.setBounds(40, 70, 200, 80);
            panel1.add(courseButton);

            lecturerButton = new JButton("Register Lecturer");
            lecturerButton.setBounds(290, 70, 200, 80);
            panel1.add(lecturerButton);

            studentButton = new JButton("Register Student");
            studentButton.setBounds(540, 70, 200, 80);
            panel1.add(studentButton);

            feeButton = new JButton("Track Fee");
            feeButton.setBounds(40, 230, 200, 80);
            panel1.add(feeButton);

            academicButton = new JButton("Track Announcements");
            academicButton.setBounds(290, 230, 200, 80);
            panel1.add(academicButton);

            examsButton = new JButton("Track Exam Results");
            examsButton.setBounds(540, 230, 200, 80);
            panel1.add(examsButton);

            enrollStudentB = new JButton("Enrollments");
            enrollStudentB.setBounds(40, 370, 120, 30);
            panel1.add(enrollStudentB);

            classesStudentB = new JButton("Classes");
            classesStudentB.setBounds(180, 370, 120, 30);
            panel1.add(classesStudentB);

            logOutButton = new JButton("LOG OUT");
            logOutButton.setBounds(640, 370, 100, 30);
            panel1.add(logOutButton);

            courseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new CoursesScreen();
                }
            });

            lecturerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new LecturerScreen();
                }
            });

            classesStudentB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ClassesScreen();
                }
            });


            studentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new StudentScreen();
                }
            });

            academicButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new AnnouncementScreen();
                }
            });

            feeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new FeeInvoiceScreen();
                }
            });

            enrollStudentB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new EnrollmentScreen();
                }
            });


            examsButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ResultScreen();
                }
            });

            logOutButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new LogInScreen();
                }
            });

            setVisible(true);
        }

        public static void main(String[] args) {
            new AdminMenuScreen();
        }
    }


