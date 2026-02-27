package gui;

import javax.swing.*;
import service.EmployeeService;

public class DeleteEmployeeGUI extends JFrame {

    EmployeeService service = new EmployeeService();

    public DeleteEmployeeGUI() {
        setTitle("Delete Employee");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel idLbl = new JLabel("Employee ID:");
        JTextField idTxt = new JTextField();
        JButton deleteBtn = new JButton("Delete");

        idLbl.setBounds(20, 20, 100, 25);
        idTxt.setBounds(130, 20, 120, 25);
        deleteBtn.setBounds(80, 80, 120, 30);

        add(idLbl);
        add(idTxt);
        add(deleteBtn);

        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idTxt.getText().trim());
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this employee?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    if (service.deleteEmployee(id)) {
                        JOptionPane.showMessageDialog(this, "Employee Deleted");
                    } else {
                        JOptionPane.showMessageDialog(this, "Delete Failed (Employee Not Found)");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID");
            }
        });

        setVisible(true);
    }
}