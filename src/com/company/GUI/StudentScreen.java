package com.company.GUI;

import com.company.ClassRoom;
import com.company.DataBase.DbOperations;
import com.company.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StudentScreen extends JFrame {

    JPanel panel1;

    JLabel idText;
    JLabel nameText;
    JLabel contactText;
    JLabel passwordText;
    JLabel semesterText;
    JLabel classText;

    JTextField idTF;
    JTextField nameTF;
    JTextField contactNoTF;
    JTextField passwordTF;
    JTextField semesterTF;

    JComboBox<String> classCB;

    JButton addButton;
    JButton backButton;

    JList<Student> list;
    DefaultListModel<Student> listModel;

    public StudentScreen() {
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

        listModel = dbOperations.getStudents("Select * from Student");

        idText = new JLabel();
        idText.setBounds(50, 30, 150, 25);
        idText.setText("Student ID");
        panel1.add(idText);

        idTF = new JTextField();
        idTF.setBounds(50, 60, 150, 25);
        idTF.setToolTipText("Enter student ID");
        panel1.add(idTF);

        nameText = new JLabel();
        nameText.setBounds(50, 90, 150, 25);
        nameText.setText("Student Name");
        panel1.add(nameText);

        nameTF = new JTextField();
        nameTF.setBounds(50, 120, 150, 25);
        nameTF.setToolTipText("Enter student name");
        panel1.add(nameTF);

        passwordText = new JLabel();
        passwordText.setBounds(50, 150, 150, 25);
        passwordText.setText("Password");
        panel1.add(passwordText);

        passwordTF = new JTextField();
        passwordTF.setBounds(50, 180, 150, 25);
        passwordTF.setToolTipText("Enter Password");
        panel1.add(passwordTF);

        contactText = new JLabel();
        contactText.setBounds(50, 210, 150, 25);
        contactText.setText("Contact No");
        panel1.add(contactText);

        contactNoTF = new JTextField();
        contactNoTF.setBounds(50, 240, 150, 25);
        contactNoTF.setToolTipText("Enter student contact no");
        panel1.add(contactNoTF);

        semesterText = new JLabel();
        semesterText.setBounds(50, 270, 150, 25);
        semesterText.setText("Semester");
        panel1.add(semesterText);

        semesterTF = new JTextField();
        semesterTF.setBounds(50, 300, 150, 25);
        semesterTF.setToolTipText("Enter student's semester");
        panel1.add(semesterTF);

        classText = new JLabel();
        classText.setBounds(50, 330, 150, 25);
        classText.setText("Select Class ID");
        panel1.add(classText);

        classCB = new JComboBox<>();
        classCB.setBounds(50, 360, 150, 25);
        classCB.setToolTipText("Select class ID to be assigned to the student");
        setClassRoomComboBox();
        panel1.add(classCB);


        JLabel label = new JLabel();
        label.setText("All Students");
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
        addButton.setBounds(90, 420, 60, 30);
        panel1.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(640, 470, 100, 30);
        panel1.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbOperations dbOperations = null;
                String classRoomId = String.valueOf(classCB.getSelectedItem());
                try {
                    dbOperations = new DbOperations();
                    Student student = new Student(idTF.getText().toString(),nameTF.getText().toString(),passwordTF.getText().toString(),
                            contactNoTF.getText().toString(),semesterTF.getText().toString(), classRoomId);
                    dbOperations.addStudent(student);
                    listModel.addElement(student);

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

    public void setClassRoomComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<ClassRoom> classRooms = dbOperations.getClassRooms("Select * from ClassRoom");

            for (int i = 0; i < classRooms.size(); i++) {
                ClassRoom classRoom = classRooms.get(i);
                classCB.addItem(classRoom.getClassRoomId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
