package pro.sky.employees.Service;

import pro.sky.employees.Employee;
import pro.sky.employees.Exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int department, int salary);


    Employee add(Employee employee);

    Employee remove(String firstName, String lastName) throws EmployeeNotFoundException;

    Employee remove(Employee employee) throws EmployeeNotFoundException;

    Employee find(String firstName, String lastName) throws EmployeeNotFoundException;

    List<Employee> allEmployees();

}