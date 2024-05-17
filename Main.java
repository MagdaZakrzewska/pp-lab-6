import java.util.ArrayList;
import java.util.List;
import company.models.Manager;
import company.models.Worker;
import company.abstracts.Employee;

public class Main {
    public static void main(String[] args) {
        
        Worker worker1 = new Worker("Anna", 5200, 1, "2020-01-01", "Junior Worker");
        Worker worker2 = new Worker("Michał", 6400, 2, "2019-05-15", "Senior Worker");
        Worker worker3 = new Worker("Robert", 2300, 3, "2021-03-20", "Mid-level Worker");
        Worker worker4 = new Worker("Igor", 1800, 4, "2018-11-10", "Senior Worker");

        Manager manager = new Manager("Jan", 7500, 5, "2017-07-01", "Senior Manager");

        List<Employee> employees = new ArrayList<>();
        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(worker4);
        employees.add(manager);

        for (Employee employee : employees) {
            System.out.println("- " + employee.getName() + " (ID: " + employee.hashCode() + 
                               ", Position: " + employee.getPosition() + 
                               ", Hire date: " + employee.getHireDate() + 
                               ", Salary: " + employee.getSalary() + ")");
            employee.work();
        }
    }
}