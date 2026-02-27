package dao;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private final String USER = "root";
    private final String PASSWORD = "123456789";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO employees(name, department, designation, salary) VALUES(?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getDesignation());
            ps.setDouble(4, emp.getSalary());
            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("designation"),
                        rs.getDouble("salary")
                ));
            }

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getString("designation"),
                        rs.getDouble("salary")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name=?, department=?, designation=?, salary=? WHERE id=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setString(3, emp.getDesignation());
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}