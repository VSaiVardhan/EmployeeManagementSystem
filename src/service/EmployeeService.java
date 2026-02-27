package service;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDAO dao = new EmployeeDAOImpl();

    public boolean addEmployee(Employee emp) {
        return dao.addEmployee(emp);
    }

    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public Employee getEmployee(int id) {
        return dao.getEmployeeById(id);
    }

    public boolean updateEmployee(Employee emp) {
        return dao.updateEmployee(emp);
    }

    public boolean deleteEmployee(int id) {
        return dao.deleteEmployee(id);
    }
}