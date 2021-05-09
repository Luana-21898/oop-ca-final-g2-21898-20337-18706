package com.company.GUI;

import com.company.DataBase.DbOperations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUpScreen extends JFrame {


    private static JLabel adminLabel;
    private static JLabel passwordLabel;
    private static JLabel nameLabel;
    private static JLabel contactLabel;
    private static JPanel panel1;
    private static JTextField idField;
    private static JPasswordField passwordField;
    private static JTextField nameField;
    private static JTextField contactField;

    private static JButton signUpButton;

    SignUpScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 170, 350, 350);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        Label label = new Label("Admin Access Only");
        label.setBounds(100, 20, 250, 25);
        panel1.add(label);

        adminLabel = new JLabel("Admin ID");
        adminLabel.setBounds(20, 80, 150, 25);
        panel1.add(adminLabel);

        idField = new JTextField();
        idField.setToolTipText("Enter Admin ID");
        idField.setBounds(110, 80, 150, 25);
        panel1.add(idField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(20, 110, 150, 25);
        panel1.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("Enter your password");
        passwordField.setBounds(110, 110, 150, 25);
        panel1.add(passwordField);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(20, 140, 150, 25);
        panel1.add(nameLabel);

        nameField = new JTextField();
        nameField.setToolTipText("Enter your name");
        nameField.setBounds(110, 140, 150, 25);
        panel1.add(nameField);

        contactLabel = new JLabel("Contact Num");
        contactLabel.setBounds(20, 170, 150, 25);
        panel1.add(contactLabel);

        contactField = new JTextField();
        contactField.setToolTipText("Enter your contact number");
        contactField.setBounds(110, 170, 150, 25);
        panel1.add(contactField);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(120, 250, 90, 25);
        panel1.add(signUpButton);


        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().toString();
                String password = passwordField.getText().toString();

                if (id.isBlank() || id.isEmpty() ||
                        password.isBlank() || password.isBlank() || nameField.getText().isEmpty() || contactField.getText().isEmpty()
                ) {
                    JOptionPane.showMessageDialog(null,
                            "Fields shouldn't be empty",
                            "Fields required",
                            JOptionPane.ERROR_MESSAGE);

                } else {
                    try {
                        DbOperations dbOperations = new DbOperations();
                        dbOperations.addAdmin(id,nameField.getText().toString(),password,contactField.getText().toString());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null,
                            "Account has been created. Enter ID or Password to Log in",
                            "Account Created",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new LogInScreen();
                }
            }
        });

        setVisible(true);
    }

}

