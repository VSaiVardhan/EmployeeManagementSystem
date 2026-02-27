package gui;

import javax.swing.*;
import service.EmployeeService;
import model.Employee;

public class AddEmployeeGUI extends JFrame {

    EmployeeService service = new EmployeeService();

    public AddEmployeeGUI() {
        setTitle("Add Employee");
        setSize(300, 350);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel nameLbl = new JLabel("Name:");
        JLabel deptLbl = new JLabel("Department:");
        JLabel desgLbl = new JLabel("Designation:");
        JLabel salaryLbl = new JLabel("Salary:");

        JTextField nameTxt = new JTextField();
        JTextField deptTxt = new JTextField();
        JTextField desgTxt = new JTextField();
        JTextField salaryTxt = new JTextField();

        JButton saveBtn = new JButton("Save");

        nameLbl.setBounds(20, 20, 100, 25);
        nameTxt.setBounds(130, 20, 120, 25);

        deptLbl.setBounds(20, 60, 100, 25);
        deptTxt.setBounds(130, 60, 120, 25);

        desgLbl.setBounds(20, 100, 100, 25);
        desgTxt.setBounds(130, 100, 120, 25);

        salaryLbl.setBounds(20, 140, 100, 25);
        salaryTxt.setBounds(130, 140, 120, 25);

        saveBtn.setBounds(80, 200, 120, 30);

        add(nameLbl); add(nameTxt);
        add(deptLbl); add(deptTxt);
        add(desgLbl); add(desgTxt);
        add(salaryLbl); add(salaryTxt);
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            try {
                String name = nameTxt.getText();
                String dept = deptTxt.getText();
                String desg = desgTxt.getText();
                double salary = Double.parseDouble(salaryTxt.getText());

                Employee emp = new Employee(name, dept, desg, salary);

                if (service.addEmployee(emp)) {
                    JOptionPane.showMessageDialog(this, "Employee Added Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to Add Employee");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input");
            }
        });

        setVisible(true);
    }
}