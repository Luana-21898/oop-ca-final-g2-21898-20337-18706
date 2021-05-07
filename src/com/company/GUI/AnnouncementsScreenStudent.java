package com.company.GUI;

import com.company.DataBase.DbOperations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AnnouncementsScreenStudent extends JFrame {

    private JPanel panel1;
    private JLabel label;
    private JButton backButton;

    private JList<String> list;
    private DefaultListModel<String> listModel = new DefaultListModel<>();

    AnnouncementsScreenStudent() {
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
            listModel = dbOperations.getAnnouncements("Select * from Announcement");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        label = new JLabel();
        label.setText("Announcements");
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

