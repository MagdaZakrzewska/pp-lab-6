import company.models.Manager;
import company.models.Worker;
import company.abstracts.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Anna", 5000.0, 1, "2017-01-01", "Księgowa");
        Worker worker2 = new Worker("Marek", 4200.0, 2, "2018-02-01", "Tłumacz");
        Worker worker3 = new Worker("Michał", 4600.0, 1, "2020-03-01", "Recepcjonista");
        Worker worker4 = new Worker("Kamil", 7600.0, 4, "2004-03-01", "Recepcjonista");
        Worker worker5 = new Worker("Jan", 3400.0, 4, "2007-03-01", "Recepcjonista");
        Manager manager1 = new Manager("Jan", 8000.0, 5, "2014-01-01", "Dyrektor");
        Manager manager2 = new Manager("Sara", 8000, 7, "2014-12-15", "Kierownik");
        Manager manager3 = new Manager("Ewa", 8000, 7, "2021-06-15", "Kierownik");

        List<Employee> employees = new ArrayList<>();
        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(worker4);
        employees.add(worker5);
        employees.add(manager1);
        employees.add(manager2);
        employees.add(manager3);

        // Wyświetlanie kodów hash
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " has code: " + employee.hashCode());
        }

        // Porównywanie obiektów za pomocą metody equals
        for (Employee employee : employees) {
            System.out.println("Comparing Marek with " + employee.getName());
            if (!employee.equals(worker2)) {
                System.out.println("Marek is not equal to " + employee.getName());
            } else {
                System.out.println("Marek is equal to " + employee.getName());
            }
        }

        // Zliczanie sumy pensji wszystkich pracowników
        double totalSalary = 0;
        double totalManagerSalary = 0;
        double totalWorkerSalary = 0;

        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
            if (employee instanceof Manager) {
                totalManagerSalary += employee.getSalary();
            } else if (employee instanceof Worker) {
                totalWorkerSalary += employee.getSalary();
            }
        }

        System.out.println("Total salary of all employees: " + totalSalary);
        System.out.println("Total salary of all managers: " + totalManagerSalary);
        System.out.println("Total salary of all workers: " + totalWorkerSalary);

        // Wyszukiwanie duplikatów na podstawie ID
        Map<Integer, List<Employee>> duplicatesMap = new HashMap<>();
        for (Employee employee : employees) {
            int id = employee.hashCode();
            if (!duplicatesMap.containsKey(id)) {
                duplicatesMap.put(id, new ArrayList<>());
            }
            duplicatesMap.get(id).add(employee);
        }

        System.out.println("Duplicate employees:");
        for (Map.Entry<Integer, List<Employee>> entry : duplicatesMap.entrySet()) {
            List<Employee> duplicateEmployees = entry.getValue();
            if (duplicateEmployees.size() > 1) {
                for (Employee employee : duplicateEmployees) {
                    System.out.println(employee.getName() + " (ID: " + employee.hashCode() + ")");
                }
            }
        }
    }
}