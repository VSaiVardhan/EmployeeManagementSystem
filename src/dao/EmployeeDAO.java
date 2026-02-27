package dao;

import java.util.List;
import model.Employee;

public interface EmployeeDAO {
    boolean addEmployee(Employee emp);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    boolean updateEmployee(Employee emp);
    boolean deleteEmployee(int id);
}