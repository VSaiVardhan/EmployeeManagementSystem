package gui;

import javax.swing.*;
import service.EmployeeService;
import model.Employee;

public class UpdateEmployeeGUI extends JFrame {

    EmployeeService service = new EmployeeService();

    public UpdateEmployeeGUI() {
        setTitle("Update Employee");
        setSize(350, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel idLbl = new JLabel("Employee ID:");
        JTextField idTxt = new JTextField();

        JButton fetchBtn = new JButton("Fetch");

        JLabel nameLbl = new JLabel("Name:");
        JLabel deptLbl = new JLabel("Department:");
        JLabel desgLbl = new JLabel("Designation:");
        JLabel salaryLbl = new JLabel("Salary:");

        JTextField nameTxt = new JTextField();
        JTextField deptTxt = new JTextField();
        JTextField desgTxt = new JTextField();
        JTextField salaryTxt = new JTextField();

        JButton updateBtn = new JButton("Update");

        idLbl.setBounds(20, 20, 120, 25);
        idTxt.setBounds(150, 20, 120, 25);
        fetchBtn.setBounds(100, 60, 120, 25);

        nameLbl.setBounds(20, 110, 120, 25);
        nameTxt.setBounds(150, 110, 120, 25);

        deptLbl.setBounds(20, 150, 120, 25);
        deptTxt.setBounds(150, 150, 120, 25);

        desgLbl.setBounds(20, 190, 120, 25);
        desgTxt.setBounds(150, 190, 120, 25);

        salaryLbl.setBounds(20, 230, 120, 25);
        salaryTxt.setBounds(150, 230, 120, 25);

        updateBtn.setBounds(100, 290, 120, 30);

        add(idLbl); add(idTxt); add(fetchBtn);
        add(nameLbl); add(nameTxt);
        add(deptLbl); add(deptTxt);
        add(desgLbl); add(desgTxt);
        add(salaryLbl); add(salaryTxt);
        add(updateBtn);

        // Fetch Employee
        fetchBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idTxt.getText().trim());
                Employee emp = service.getEmployee(id);

                if (emp == null) {
                    JOptionPane.showMessageDialog(this, "Employee Not Found");
                    return;
                }

                nameTxt.setText(emp.getName());
                deptTxt.setText(emp.getDepartment());
                desgTxt.setText(emp.getDesignation());
                salaryTxt.setText(String.valueOf(emp.getSalary()));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID Format");
            }
        });

        // Update Employee
        updateBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idTxt.getText().trim());
                String name = nameTxt.getText();
                String dept = deptTxt.getText();
                String desg = desgTxt.getText();
                double salary = Double.parseDouble(salaryTxt.getText());

                Employee emp = new Employee(id, name, dept, desg, salary);

                if (service.updateEmployee(emp)) {
                    JOptionPane.showMessageDialog(this, "Employee Updated Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Update Failed");
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Data");
            }
        });

        setVisible(true);
    }
}