package pro.sky.employees.Service.ServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.employees.Employee;
import pro.sky.employees.Exceptions.EmployeeExistsException;
import pro.sky.employees.Exceptions.EmployeeNotFoundException;
import pro.sky.employees.Service.EmployeeService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final Set<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int department, int salary) {
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            firstName = StringUtils.capitalize(firstName);
            lastName = StringUtils.capitalize(lastName);
        } else {
            throw new IllegalArgumentException();
        }
        Employee newEmployee = new Employee(firstName, lastName, department, salary);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {

        boolean employeeAlreadyExist = !employees.add(employee);
        if (employeeAlreadyExist) {
            throw new EmployeeExistsException();
        }

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) throws EmployeeNotFoundException {
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public List<Employee> allEmployees() {
        return (List<Employee>) Set.copyOf(employees);
    }


    private String getKey(Employee employee) {
        return getKey(employee.getFirstName(), employee.getLastName(), employee.getDepartment(), employee.getSalary());
    }

    private String getKey(String firstName, String lastName, int department, int salary) {
        return firstName + " " + lastName + " " + department + " " + salary;
    }


}
