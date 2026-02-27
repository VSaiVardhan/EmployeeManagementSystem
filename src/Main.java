import java.util.List;
import java.util.Scanner;
import model.Employee;
import service.EmployeeService;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    System.out.print("Designation: ");
                    String desg = sc.nextLine();

                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();

                    Employee e = new Employee(name, dept, desg, salary);

                    if (service.addEmployee(e))
                        System.out.println("Employee added successfully!");
                    else
                        System.out.println("Failed to add employee.");

                    break;

                case 2:
                    List<Employee> list = service.getAllEmployees();
                    System.out.println("\nID | Name | Dept | Designation | Salary");
                    for (Employee emp : list) {
                        System.out.println(emp);
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int uid = sc.nextInt();
                    Employee empToUpdate = service.getEmployee(uid);

                    if (empToUpdate == null) {
                        System.out.println("Employee not found.");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("New Name: ");
                    empToUpdate.setName(sc.nextLine());

                    System.out.print("New Department: ");
                    empToUpdate.setDepartment(sc.nextLine());

                    System.out.print("New Designation: ");
                    empToUpdate.setDesignation(sc.nextLine());

                    System.out.print("New Salary: ");
                    empToUpdate.setSalary(sc.nextDouble());

                    if (service.updateEmployee(empToUpdate))
                        System.out.println("Employee updated!");
                    else
                        System.out.println("Update failed.");
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int did = sc.nextInt();

                    if (service.deleteEmployee(did))
                        System.out.println("Employee deleted.");
                    else
                        System.out.println("Delete failed.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}