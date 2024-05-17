import company.models.Manager;
import company.models.Worker;
import company.abstracts.Employee;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Anna", 5000.0, 1, "2017-01-01", "Księgowa");
        Worker worker2 = new Worker("Marek", 4200.0, 2, "2018-02-01", "Tłumacz");
        Worker worker3 = new Worker("Michał", 4600.0, 2, "2020-03-01", "Rececjonista");
        Manager manager1 = new Manager("Jan", 8000.0, 5, "2014-01-01", "Dyrektor");

        
        List<Employee> employees = new ArrayList<>();
        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(manager1);

        
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " has code: " + employee.hashCode());
        }

        
        for (Employee employee : employees) {
            System.out.println("Comparing Marek with " + employee.getName());
            if (!employee.equals(worker2)) {
                System.out.println("Marek is not equal to " + employee.getName());
            } else {
                System.out.println("Marek is equal to " + employee.getName());
            }
        }
    }
}