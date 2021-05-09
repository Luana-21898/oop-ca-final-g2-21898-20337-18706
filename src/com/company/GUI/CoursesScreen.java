package com.company.GUI;

import com.company.Course;
import com.company.DataBase.DbOperations;
import com.company.Lecturer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CoursesScreen extends JFrame {

    JPanel panel1;

    JLabel idText;
    JLabel nameText;
    JLabel creditText;
    JLabel semesterText;
    JLabel lecturerText;

    JTextField idTF;
    JTextField nameTF;
    JTextField semesterTF;
    JTextField creditHoursTF;

    JButton addButton;
    JButton backButton;
    JComboBox<String> lecturersCB;

    JList<Course> list;
    DefaultListModel<Course> listModel = new DefaultListModel<>();

    public CoursesScreen() {
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

        listModel = dbOperations.getCourses("Select * from Course");

        idText = new JLabel();
        idText.setBounds(50, 30, 150, 25);
        idText.setText("Module ID");
        panel1.add(idText);

        idTF = new JTextField();
        idTF.setBounds(50, 60, 150, 25);
        idTF.setToolTipText("Enter module ID");
        panel1.add(idTF);

        nameText = new JLabel();
        nameText.setBounds(50, 90, 150, 25);
        nameText.setText("Module Name");
        panel1.add(nameText);

        nameTF = new JTextField();
        nameTF.setBounds(50, 120, 150, 25);
        nameTF.setToolTipText("Enter module name");
        panel1.add(nameTF);

        creditText = new JLabel();
        creditText.setBounds(50, 150, 150, 25);
        creditText.setText("Module Hours");
        panel1.add(creditText);

        creditHoursTF = new JTextField();
        creditHoursTF.setBounds(50, 180, 150, 25);
        creditHoursTF.setToolTipText("Enter module hours");
        panel1.add(creditHoursTF);

        semesterText = new JLabel();
        semesterText.setBounds(50, 210, 150, 25);
        semesterText.setText("Semester");
        panel1.add(semesterText);

        semesterTF = new JTextField();
        semesterTF.setBounds(50, 240, 150, 25);
        semesterTF.setToolTipText("Enter Semester");
        panel1.add(semesterTF);

        lecturerText = new JLabel();
        lecturerText.setBounds(50, 270, 150, 25);
        lecturerText.setText("Lecturer");
        panel1.add(lecturerText);

        lecturersCB = new JComboBox();
        lecturersCB.setToolTipText("Select Lecturer");
        lecturersCB.setBounds(50, 300, 150, 25);
        setLecturerComboBox();
        panel1.add(lecturersCB);

        JLabel label = new JLabel();
        label.setText("All Courses");
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
        addButton.setBounds(90, 350, 60, 30);
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

                    int a = Integer.parseInt(creditHoursTF.getText().toString());
                    String lecturerId = String.valueOf(lecturersCB.getSelectedItem());

                    Course course = new Course(idTF.getText().toString(), nameTF.getText().toString(), semesterTF.getText().toString(), a, lecturerId);
                    listModel.addElement(course);
                    dbOperations.addCourse(course);

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

    public void setLecturerComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<Lecturer> lecturers = dbOperations.getLecturers("Select * from Lecturer");

            for (int i = 0; i < lecturers.size(); i++) {
                Lecturer lecturer = lecturers.get(i);
                lecturersCB.addItem(lecturer.getLecturerId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
