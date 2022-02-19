package pro.sky.employees.Service.ServiceImpl;

import org.springframework.stereotype.Service;
import pro.sky.employees.Employee;
import pro.sky.employees.Exceptions.EmployeeNotFoundException;
import pro.sky.employees.Service.DepartmentService;
import pro.sky.employees.Service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee employeeMinSalary(int department) throws EmployeeNotFoundException {
        return employeeService.allEmployees().stream()
                .filter(employee -> employee.hisDepartment(department))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Работник в " + department + "не найден"));
    }

    @Override
    public Employee employeeMaxSalary(int department) throws EmployeeNotFoundException {
        return employeeService.allEmployees().stream()
                .filter(employee -> employee.hisDepartment(department))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Работник в " + department + "не найден"));
    }

    @Override
    public Collection<Employee> getEmployeesFor(int department) {
        return employeeService.allEmployees().stream()
                .filter(employee -> employee.hisDepartment(department))
                .collect(Collectors.toList());
    }


    @Override
    public Map<Integer, List<Employee>> getAllEmployeesDepartment() {
        return employeeService.allEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
