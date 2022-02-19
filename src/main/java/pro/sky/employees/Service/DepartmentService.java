package pro.sky.employees.Service;

import pro.sky.employees.Employee;
import pro.sky.employees.Exceptions.EmployeeNotFoundException;

import java.util.Collection;

public interface DepartmentService {

    Employee employeeMinSalary(int department) throws EmployeeNotFoundException;

    Employee employeeMaxSalary(int department) throws EmployeeNotFoundException;

    Collection<Employee> getEmployeesFor(int department);

    Object getAllEmployeesDepartment();
    
}
