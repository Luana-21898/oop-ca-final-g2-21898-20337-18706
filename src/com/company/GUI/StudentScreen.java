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

        idTF = new JTextField();
        idTF.setBounds(50, 60, 150, 25);
        idTF.setToolTipText("Enter student Id");
        panel1.add(idTF);

        nameTF = new JTextField();
        nameTF.setBounds(50, 120, 150, 25);
        nameTF.setToolTipText("Enter student name");
        panel1.add(nameTF);

        passwordTF = new JTextField();
        passwordTF.setBounds(50, 180, 150, 25);
        passwordTF.setToolTipText("Enter Password");
        panel1.add(passwordTF);

        contactNoTF = new JTextField();
        contactNoTF.setBounds(50, 240, 150, 25);
        contactNoTF.setToolTipText("Enter student contact no");
        panel1.add(contactNoTF);

        semesterTF = new JTextField();
        semesterTF.setBounds(50, 300, 150, 25);
        semesterTF.setToolTipText("Enter semester of student");
        panel1.add(semesterTF);

        classCB = new JComboBox<>();
        classCB.setBounds(50, 360, 150, 25);
        classCB.setToolTipText("Select class Id to be assigned to student");
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
                String classId = String.valueOf(classCB.getSelectedItem());
                try {
                    dbOperations = new DbOperations();
                    Student student = new Student(idTF.getText().toString(),nameTF.getText().toString(),passwordTF.getText().toString(),
                            contactNoTF.getText().toString(),semesterTF.getText().toString(), classId);
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
