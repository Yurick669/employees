package pro.sky.employees.Service;

import pro.sky.employees.Employee;

import java.util.Collection;

public interface DepartmentService {

    Employee employeeMinSalary(int department);

    Employee employeeMaxSalary(int department);

    Collection<Employee> getEmployeesFor(int department);

    Object getAllEmployeesDepartment();
    
}
