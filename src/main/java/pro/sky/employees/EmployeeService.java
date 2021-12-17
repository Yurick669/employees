package pro.sky.employees;

public interface EmployeeService {

    Employee add(String firstname, String lastname);

    Employee add(Employee employee);

    Employee remove(String firstname, String lastname);

    Employee remove(Employee employee);

    Employee find(String firstname, String lastname);
}
