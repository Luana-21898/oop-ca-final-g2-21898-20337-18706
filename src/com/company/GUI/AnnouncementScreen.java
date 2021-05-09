package com.company.GUI;

import com.company.DataBase.DbOperations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AnnouncementScreen extends JFrame {

    JPanel panel1;

    JLabel detailsLabel;
    JLabel semesterLabel;
    JLabel allLabel;

    JTextField detailsField;
    JTextField semesterField;

    JButton addButton;
    JButton backButton;

    JList<String> list;
    DefaultListModel<String> listModel;

    public AnnouncementScreen(){
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
            listModel = dbOperations.getAnnouncements("Select * from Announcement");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        detailsLabel = new JLabel();
        detailsLabel.setText("Announcement");
        detailsLabel.setBounds(50, 40, 150, 25);
        panel1.add(detailsLabel);

        detailsField = new JTextField();
        detailsField.setBounds(50,70,150,25);
        detailsField.setToolTipText("Enter announcement");
        panel1.add(detailsField);

        semesterLabel = new JLabel();
        semesterLabel.setText("Semester");
        semesterLabel.setBounds(50, 100, 150, 25);
        panel1.add(semesterLabel);

        semesterField = new JTextField();
        semesterField.setBounds(50,130,150,25);
        semesterField.setToolTipText("Enter semester");
        panel1.add(semesterField);


        allLabel = new JLabel();
        allLabel.setText("All Announcements");
        allLabel.setBounds(500, 10, 200, 25);
        panel1.add(allLabel);


        list = new JList<>(listModel);
        list.setBounds(350,60,400,400);
        panel1.add(list);

        JScrollPane scrollPane = new JScrollPane(list,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
        panel1.add(scrollPane);


        addButton = new JButton("Add");
        addButton.setBounds(90, 250, 60, 30);
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
                    String detail = detailsField.getText().toString();
                    String semester = semesterField.getText().toString();
                    String announcement = detail + " for semester : " + semester;
                    listModel.addElement(announcement);
                    dbOperations.addAnnouncement(detail,semester);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(LogInScreen.lecturerId != null){
                    new LecturersMenuScreen();
                } else {
                    new AdminMenuScreen();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AnnouncementScreen();
    }
}

