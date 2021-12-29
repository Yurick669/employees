package pro.sky.employees.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.employees.Employee;
import pro.sky.employees.Exceptions.EmployeeExistsException;
import pro.sky.employees.Exceptions.EmployeeNotFoundExtсeption;
import pro.sky.employees.Service.EmployeeService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new LinkedHashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {

        String key = getKey(employee);
        if (employees.containsKey(key)) {
            throw new EmployeeExistsException();
        }
        employees.put(key, employee);

        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        Employee removeEmployee = employees.remove(getKey(employee));
        if (removeEmployee == null) {
            throw new EmployeeNotFoundExtсeption();
        }
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        Employee employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundExtсeption();
        }
        return employee;
    }

    @Override
    public Set<Employee> allEmployees() {
        return Set.copyOf(employees.values());
    }


    private String getKey(Employee employee) {
        return getKey(employee.getFirstName(), employee.getLastName());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }


}
