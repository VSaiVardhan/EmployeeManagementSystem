package gui;

import javax.swing.*;
import java.awt.*;
import service.EmployeeService;

public class MainGUI extends JFrame {

    EmployeeService service = new EmployeeService();

    public MainGUI() {
        setTitle("Employee Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton addBtn = new JButton("Add Employee");
        JButton viewBtn = new JButton("View Employees");
        JButton updateBtn = new JButton("Update Employee");
        JButton deleteBtn = new JButton("Delete Employee");
        JButton exitBtn = new JButton("Exit");

        add(addBtn);
        add(viewBtn);
        add(updateBtn);
        add(deleteBtn);
        add(exitBtn);

        addBtn.addActionListener(e -> new AddEmployeeGUI());
        viewBtn.addActionListener(e -> new ViewEmployeesGUI());
        updateBtn.addActionListener(e -> new UpdateEmployeeGUI());
        deleteBtn.addActionListener(e -> new DeleteEmployeeGUI());
        exitBtn.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}