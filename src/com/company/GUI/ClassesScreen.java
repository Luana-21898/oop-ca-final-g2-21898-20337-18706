package com.company.GUI;

import com.company.ClassRoom;
import com.company.DataBase.DbOperations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ClassesScreen extends JFrame {

    JPanel panel1;

    JTextField idTF;

    JButton addButton;
    JButton backButton;

    JList<ClassRoom> list;
    DefaultListModel<ClassRoom> listModel;

    public ClassesScreen(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 800, 550);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        setLayout(null);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        try {
            DbOperations dbOperations = new DbOperations();
            listModel = dbOperations.getClassRooms("Select * from ClassRoom");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        idTF = new JTextField();
        idTF.setBounds(50,60,150,25);
        idTF.setToolTipText("Enter class room Id");
        panel1.add(idTF);


        JLabel label = new JLabel();
        label.setText("All Class Rooms");
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
        addButton.setBounds(90, 200, 60, 30);
        panel1.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(640, 470, 100, 30);
        panel1.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DbOperations dbOperations = new DbOperations();
                    ClassRoom classRoom = new ClassRoom(idTF.getText().toString());
                    dbOperations.addClassRoom(classRoom);
                    listModel.addElement(classRoom);
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

