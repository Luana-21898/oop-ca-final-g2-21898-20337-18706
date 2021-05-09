package com.company.GUI;

import com.company.DataBase.DbOperations;
import com.company.FeeInvoice;
import com.company.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FeeInvoiceScreen extends JFrame {

    JPanel panel1;

    JLabel studentText;
    JLabel feeText;
    JLabel instText;
    JLabel remText;
    JLabel dueText;

    JTextField feeTF;
    JTextField installmentTF;
    JTextField remainingTF;
    JTextField dueDateTF;

    JComboBox<String> statusCB;
    JComboBox<String> studentIdCB;

    JButton addButton;
    JButton backButton;

    JList<FeeInvoice> list;
    DefaultListModel<FeeInvoice> listModel;

    public FeeInvoiceScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 150, 800, 550);
        panel1 = new JPanel();
        setContentPane(panel1);
        setResizable(false);
        setLayout(null);
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        try {
            DbOperations dbOperations = new DbOperations();
            listModel = dbOperations.getInvoices("Select * from FeeInvoice");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        studentText = new JLabel();
        studentText.setBounds(50, 30, 150, 25);
        studentText.setText("Student ID");
        panel1.add(studentText);

        studentIdCB = new JComboBox<>();
        studentIdCB.setBounds(50, 60, 150, 25);
        studentIdCB.setToolTipText("Select Student ID");
        setStudentComboBox();
        panel1.add(studentIdCB);

        instText = new JLabel();
        instText.setBounds(50, 90, 150, 25);
        instText.setText("Installment");
        panel1.add(instText);

        installmentTF = new JTextField();
        installmentTF.setBounds(50, 120, 150, 25);
        installmentTF.setToolTipText("Enter Installment");
        panel1.add(installmentTF);

        feeText = new JLabel();
        feeText.setBounds(50, 150, 150, 25);
        feeText.setText("Fee");
        panel1.add(feeText);

        feeTF = new JTextField();
        feeTF.setBounds(50, 180, 150, 25);
        feeTF.setToolTipText("Enter Fee");
        panel1.add(feeTF);

        remText = new JLabel();
        remText.setBounds(50, 210, 150, 25);
        remText.setText("Remaining Fee");
        panel1.add(remText);

        remainingTF = new JTextField();
        remainingTF.setBounds(50,240,150,25);
        remainingTF.setToolTipText("Enter remaining Fee");
        panel1.add(remainingTF);

        dueText = new JLabel();
        dueText.setBounds(50, 270, 150, 25);
        dueText.setText("Due Date");
        panel1.add(dueText);

        dueDateTF = new JTextField();
        dueDateTF.setBounds(50,300,150,25);
        dueDateTF.setToolTipText("Enter due date ");
        panel1.add(dueDateTF);

        String[] statueses = {"Pending","Submitted"};
        statusCB = new JComboBox<>(statueses);
        statusCB.setBounds(50,360,150,25);
        statusCB.setToolTipText("Select status");
        panel1.add(statusCB);


        JLabel label = new JLabel();
        label.setText("All Fee Invoices");
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
        addButton.setBounds(90, 410, 60, 30);
        panel1.add(addButton);

        backButton = new JButton("Back");
        backButton.setBounds(640, 470, 100, 30);
        panel1.add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DbOperations dbOperations = new DbOperations();
                    String studentId = String.valueOf(studentIdCB.getSelectedItem());
                    String status = String.valueOf(statusCB.getSelectedItem());

                    FeeInvoice invoice = new FeeInvoice(studentId,Double.parseDouble(feeTF.getText().toString()),
                            Double.parseDouble(installmentTF.getText().toString()),Double.parseDouble(remainingTF.getText().toString()),
                            status,dueDateTF.getText().toString());
                    listModel.addElement(invoice);
                    dbOperations.addInvoice(invoice);
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

    public void setStudentComboBox() {
        try {
            DbOperations dbOperations = new DbOperations();
            DefaultListModel<Student> students = dbOperations.getStudents("Select * from Student");

            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                studentIdCB.addItem(student.getId());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
