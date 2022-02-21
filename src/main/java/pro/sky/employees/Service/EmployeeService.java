package pro.sky.employees.Service;

import pro.sky.employees.Employee;

import java.util.Set;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee employee);

    Employee find(String firstName, String lastName);

    Set<Employee> allEmployees();

}