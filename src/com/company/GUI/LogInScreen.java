package com.company.GUI;

import com.company.DataBase.DbOperations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class LogInScreen extends JFrame {

    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JLabel vgcTitle;
    private static JPanel panel1;
    private static JTextField idField;
    private static JPasswordField passwordField;
    private static JButton logInButton;

    JCheckBox adminLogIn;
    JCheckBox studentLogIn;
    JCheckBox lecturerLogIn;

    public static String studentId = null;
    public static String lecturerId = null;
    public static String adminId = null;

    public LogInScreen() {
        setTitle("VGC");
        setBounds(500, 200, 350, 350);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        vgcTitle = new JLabel("VIRTUAL GLOBAL COLLEGE");
        vgcTitle.setBounds(90, 10, 200, 25);
        panel1.add(vgcTitle);

        userLabel = new JLabel("User ID");
        userLabel.setBounds(10, 40, 80, 25);
        panel1.add(userLabel);

        idField = new JTextField();
        idField.setToolTipText("Enter your registered ID");
        idField.setBounds(100, 40, 165, 25);
        panel1.add(idField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 70, 80, 25);
        panel1.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("Enter your password");
        passwordField.setBounds(100, 70, 165, 25);
        panel1.add(passwordField);

        adminLogIn = new JCheckBox("Admin");
        adminLogIn.setBounds(120, 110, 150, 25);
        panel1.add(adminLogIn);

        lecturerLogIn = new JCheckBox("Lecturer");
        lecturerLogIn.setBounds(120, 140, 150, 25);
        panel1.add(lecturerLogIn);

        studentLogIn = new JCheckBox("Student");
        studentLogIn.setBounds(120, 170, 150, 25);
        panel1.add(studentLogIn);


        logInButton = new JButton("Log In");
        logInButton.setBounds(120, 220, 90, 25);
        panel1.add(logInButton);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(120, 260, 90, 25);
        panel1.add(signUpButton);

        adminLogIn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lecturerLogIn.setSelected(false);
                studentLogIn.setSelected(false);
            }
        });

        lecturerLogIn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                adminLogIn.setSelected(false);
                studentLogIn.setSelected(false);
            }
        });

        studentLogIn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                adminLogIn.setSelected(false);
                lecturerLogIn.setSelected(false);
            }
        });

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().toString();
                String pswd = passwordField.getText().toString();

                if (id.isBlank() || id.isEmpty() ||
                        pswd.isBlank() || pswd.isBlank()
                ) {
                    JOptionPane.showMessageDialog(null,
                            "Fields shouldn't be empty",
                            "Fields required",
                            JOptionPane.ERROR_MESSAGE);
                } else {

                    if (adminLogIn.isSelected()) {
                        try {
                            DbOperations dbOperations = new DbOperations();
                            int authorized = dbOperations.isAuthorized("Select * from Admin where adminId = '"+ id +"' and password = '" + pswd + "'");
                            if(authorized == 1){
                                adminId = id;
                                dispose();
                                new AdminMenuScreen();
                                return;
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    } else if (lecturerLogIn.isSelected()) {
                        try {
                            DbOperations dbOperations = new DbOperations();
                            int authorized = dbOperations.isAuthorized("Select * from Lecturer where lecturerId = '"+ id +"' and password = '" + pswd + "'");
                            if(authorized == 1){
                                lecturerId = id;
                                dispose();
                                new LecturersMenuScreen();
                                return;
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    } else if (studentLogIn.isSelected()) {
                        try {
                            DbOperations dbOperations = new DbOperations();
                            int authorized = dbOperations.isAuthorized("Select * from Student where studentId = '"+ id +"' and password = '" + pswd + "'");
                            if(authorized == 1){
                                studentId = id;
                                dispose();
                                new StudentMenuScreen();
                                return;
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Selection required",
                                "Check one box to continue",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null,
                            "Your Id or Password is incorrect",
                            "Check your Id or Password",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUpScreen();
            }
        });

        setVisible(true);
    }

}

