package model;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String designation;
    private double salary;

    public Employee(String name, String department, String designation, double salary) {
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public Employee(int id, String name, String department, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    // getters / setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getDesignation() { return designation; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setDesignation(String designation) { this.designation = designation; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + designation + " | " + salary;
    }
}