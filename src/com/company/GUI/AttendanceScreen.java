package com.company.GUI;

import com.company.*;
import com.company.DataBase.DbOperations;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class AttendanceScreen extends JFrame {

    JPanel panel1;

    JLabel courseText;
    JLabel classText;
    JLabel studentText;

    JComboBox<String> courseCB;
    JComboBox<String> studentCB;
    JComboBox<String> classCB;


    JButton addButton;
    JButton backButton;
    JButton saveButton;
    JButton loadButton;
    JButton showButton;

    JCheckBox allPresentCB;
    JCheckBox allAbsentCB;

    JList<Enrollment> list;
    DefaultListModel<Enrollment> listModel = new DefaultListModel<>();
    ArrayList<String> absentOnes = new ArrayList<>();

    public AttendanceScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 800, 550);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        setLayout(null);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));

        courseText = new JLabel();
        courseText.setBounds(50, 30, 150, 25);
        courseText.setText("Module ID");
        panel1.add(courseText);

        courseCB = new JComboBox<>();
        courseCB.setBounds(50, 60, 150, 25);
        setCourseComboBox();
        courseCB.setToolTipText("Select module ID");
        panel1.add(courseCB);

        classText = new JLabel();
        classText.setBounds(50, 90, 150, 25);
        classText.setText("Classroom ID");
        panel1.add(classText);

        classCB = new JComboBox<>();
        classCB.setBounds(50, 120, 150, 25);
        setClassRoomComboBox();
        classCB.setToolTipText("Select Classroom ID");
        panel1.add(classCB);

        loadButton = new JButton("Load Students");
        loadButton.setBounds(50, 180, 150, 30);
        panel1.add(loadButton);

        allPresentCB = new JCheckBox("All Present");
        allPresentCB.setBounds(50, 240, 150, 30);
        panel1.add(allPresentCB);

        allAbsentCB = new JCheckBox("All Absent");
        allAbsentCB.setBounds(50, 280, 150, 30);
        panel1.add(allAbsentCB);

        JLabel label = new JLabel("Enter student's absence details.");
        label.setBounds(50, 320, 250, 15);
        panel1.add(label);

        JLabel label2 = new JLabel("Make sure to uncheck the boxes above.");
        label2.setBounds(50, 350, 270, 10);
        panel1.add(label2);

        studentText = new JLabel();
        studentText.setBounds(50, 370, 150, 25);
        studentText.setText("Student ID");
        panel1.add(studentText);

        studentCB = new JComboBox<>();
        studentCB.setBounds(50, 400, 150, 25);
        setStudentComboBox();
        studentCB.setToolTipText("Enter student ID");
        panel1.add(studentCB);


        JLabel label1 = new JLabel();
        label1.setText("Enrolled Students");
        label1.setBounds(500, 10, 200, 25);
        panel1.add(label1);

        list = new JList<>(listModel);
        list.setBounds(350, 60, 400, 400);
        panel1.add(list);

        JScrollPane scrollPane = new JScrollPane(list,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(list.getX(), list.getY(), list.getWidth(), list.getHeight());
        panel1.add(scrollPane);

        addButton = new JButton("Add to absent list");
        addButton.setBounds(50, 450, 150, 30);
        panel1.add(addButton);


        allPresentCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                allAbsentCB.setSelected(false);
            }
        });

        allAbsentCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                allPresentCB.setSelected(false);
            }
        });

        saveButton = new JButton("Save");
        saveButton.setBounds(400, 470, 100, 30);
        panel1.add(saveButton);

        showButton = new JButton("Show All");
        showButton.setBounds(520, 470, 100, 30);
        panel1.add(showButton);

        backButton = new JButton("Back");
        backButton.setBounds(640, 470, 100, 30);
        panel1.add(backButton);


        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DbOperations dbOperations = new DbOperations();
                    String courseId = String.valueOf(courseCB.getSelectedItem());
                    String classId = String.valueOf(classCB.getSelectedItem());

                    listModel.removeAllElements();
                    DefaultListModel<Enrollment> enrollments = dbOperations.getEnrollments("Select * from Enrollment " +
                            "where lecturerId = '" + LogInScreen.lecturerId + "' AND " + "courseId = '" + courseId + "' AND " + "classId = '" + classId + "'");
                    for (int i = 0; i < enrollments.size(); i++) {
                        listModel.addElement(enrollments.get(i));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                absentOnes.add(String.valueOf(studentCB.getSelectedItem()));
                System.out.println(absentOnes);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (allPresentCB.isSelected()) {
                    for (int i = 0; i < listModel.size(); i++) {
                        Enrollment enrollment = listModel.get(i);
                        LocalDate now = LocalDate.now();
                        Attendance attendance = new Attendance(enrollment.getStudentId(), "Present", now.toString(), enrollment.getCourseId(), enrollment.getLecturerId(), enrollment.getClassId());
                        try {
                            DbOperations dbOperations = new DbOperations();
                            dbOperations.addAttendance(attendance);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                } else if (allAbsentCB.isSelected()) {
                    for (int i = 0; i < listModel.size(); i++) {
                        Enrollment enrollment = listModel.get(i);
                        LocalDate now = LocalDate.now();
                        Attendance attendance = new Attendance(enrollment.getStudentId(), "Absent", now.toString(), enrollment.getCourseId(), enrollment.getLecturerId(), enrollment.getClassId());
                        try {
                            DbOperations dbOperations = new DbOperations();
                            dbOperations.addAttendance(attendance);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                } else {
                    for (int i = 0; i < listModel.size(); i++) {
                        Enrollment enrollment = listModel.get(i);
                        LocalDate now = LocalDate.now();
                        Attendance attendance = null;
                        if( isExists(enrollment.getStudentId()) ){
                            attendance = new Attendance(enrollment.getStudentId(), "Absent", now.toString(), enrollment.getCourseId(), enrollment.getLecturerId(), enrollment.getClassId());
                        } else {
                            attendance = new Attendance(enrollment.getStudentId(), "Present", now.toString(), enrollment.getCourseId(), enrollment.getLecturerId(), enrollment.getClassId());
                        }

                        try {
                            DbOperations dbOperations = new DbOperations();
                            dbOperations.addAttendance(attendance);
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LecturersMenuScreen();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AllAttendance();
            }
        });

        setVisible(true);
    }

    public void setStudentComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<Student> students = dbOperations.getStudents("Select * from Student");

            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                studentCB.addItem(student.getId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCourseComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<Course> courses = dbOperations.getCourses("Select * from Course");

            for (int i = 0; i < courses.size(); i++) {
                Course course = courses.get(i);
                courseCB.addItem(course.getCourseId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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


    private boolean isExists(String name){
        for(String s : absentOnes){
            if(s.equals(name)) {
                return true;
            }
        }
        return false;
    }

}
