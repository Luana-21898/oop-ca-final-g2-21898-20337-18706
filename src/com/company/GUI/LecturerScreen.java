package com.company.GUI;

import com.company.DataBase.DbOperations;
import com.company.Lecturer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LecturerScreen extends JFrame {

    JPanel panel1;

    JLabel idText;
    JLabel nameText;
    JLabel contactText;
    JLabel passwordText;

    JTextField idTF;
    JTextField nameTF;
    JTextField contactNoTF;
    JTextField passwordTF;

    JButton addButton;
    JButton backButton;

    JList<Lecturer> list;
    DefaultListModel<Lecturer> listModel;
    public LecturerScreen(){
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
        listModel = dbOperations.getLecturers("Select * from Lecturer");

        idText = new JLabel();
        idText.setBounds(50, 30, 150, 25);
        idText.setText("Lecturer ID");
        panel1.add(idText);

        idTF = new JTextField();
        idTF.setBounds(50,60,150,25);
        idTF.setToolTipText("Enter Lecturer ID");
        panel1.add(idTF);

        nameText = new JLabel();
        nameText.setBounds(50, 90, 150, 25);
        nameText.setText("Lecturer Name");
        panel1.add(nameText);

        nameTF = new JTextField();
        nameTF.setBounds(50,120,150,25);
        nameTF.setToolTipText("Enter Lecturer Name");
        panel1.add(nameTF);

        passwordText = new JLabel();
        passwordText.setBounds(50, 150, 150, 25);
        passwordText.setText("Password");
        panel1.add(passwordText);

        passwordTF = new JTextField();
        passwordTF.setBounds(50,180,150,25);
        passwordTF.setToolTipText("Enter Password");
        panel1.add(passwordTF);

        contactText = new JLabel();
        contactText.setBounds(50, 210, 150, 25);
        contactText.setText("Contact No");
        panel1.add(contactText);

        contactNoTF = new JTextField();
        contactNoTF.setBounds(50,240,150,25);
        contactNoTF.setToolTipText("Enter lecturer contact no");
        panel1.add(contactNoTF);

        JLabel label = new JLabel();
        label.setText("All Lecturers");
        label.setBounds(500, 10, 200, 25);
        panel1.add(label);

        list = new JList<>(listModel);
        list.setBounds(350,60,400,400);
        panel1.add(list);

        JScrollPane scrollPane = new JScrollPane(list,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
        panel1.add(scrollPane);


        addButton = new JButton("Add");
        addButton.setBounds(90, 310, 60, 30);
        panel1.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(640, 470, 100, 30);
        panel1.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbOperations dbOperations = null;
                try {
                    dbOperations = new DbOperations();
                    Lecturer lecturer = new Lecturer(idTF.getText().toString(),nameTF.getText().toString(),passwordTF.getText().toString(),contactNoTF.getText().toString());
                    listModel.addElement(lecturer);
                    dbOperations.addLecturer(lecturer);

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

}
