import java.util.*;
import java.util.stream.*;
class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
public class EmployeeDataProcessing {
		public static void process(List<Employee> employees) {
			Map<String, Double> avgSalaryByDept = employees.stream()
            .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("Average Salary by Department: " + avgSalaryByDept);
	}
		public static void main(String[] args) {
	        List<Employee> employees = Arrays.asList(
	            new Employee(1, "Alice", "Engineering", 90000),
	            new Employee(2, "Bob", "Engineering", 85000),
	            new Employee(3, "Carol", "HR", 75000),
	            new Employee(4, "Dave", "Engineering", 95000),
	            new Employee(5, "Eve", "Finance", 82000)
	        );

	        process(employees);
	    }
}