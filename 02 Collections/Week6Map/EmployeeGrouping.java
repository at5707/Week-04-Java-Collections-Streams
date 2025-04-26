import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    String name;
    Department department;
    public Employee(String name,Department department) {
        this.name=name;
        this.department=department;
    }
    public String getName() {
        return name;
    }
    public Department getDepartment() {
        return department;
    }
}
enum Department {
    HR,IT,SALES,MARKETING;
}
public class EmployeeGrouping {
    public static void main(String[] args) {
        List<Employee> employees=Arrays.asList(
            new Employee("Alice", Department.HR),
            new Employee("Bob", Department.IT),
            new Employee("Carol", Department.HR)
        );
        Map<Department,List<Employee>> groupedByDepartment=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach((department,employeeList)->{
            System.out.println(department+": "+employeeList.stream()
                              .map(Employee::getName)
                              .collect(Collectors.toList()));
        }); 
    }
}