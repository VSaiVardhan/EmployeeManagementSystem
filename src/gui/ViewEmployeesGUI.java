package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import service.EmployeeService;
import java.util.List;

public class ViewEmployeesGUI extends JFrame {

    EmployeeService service = new EmployeeService();

    public ViewEmployeesGUI() {
        setTitle("Employee List");
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Name", "Department", "Designation", "Salary"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        List<Employee> employees = service.getAllEmployees();
        for (Employee e : employees) {
            model.addRow(new Object[]{
                    e.getId(), e.getName(), e.getDepartment(), e.getDesignation(), e.getSalary()
            });
        }

        setVisible(true);
    }
}