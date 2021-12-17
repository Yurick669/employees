package pro.sky.employees;

import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employees;
    private int size;

    public EmployeeServiceImpl() {
        employees = new Employee[10];
    }

    @Override
    public Employee add(String firstname, String lastname) throws EmployeeBookOverflowException {
        Employee newEmployee = new Employee(firstname, lastname);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) throws EmployeeExistsException, EmployeeBookOverflowException {
        if (size == employees.length) {
            throw new EmployeeBookOverflowException();
        }
        int index = indexOf(employee);
        if (index != -1) {
            throw new EmployeeExistsException();
        }
        employees[size++] = employee;
        return employee;
    }

    @Override
    public Employee remove(String firstname, String lastname) throws EmployeeNotFoundExtсeption {
        Employee newEmployee = new Employee(firstname, lastname);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) throws EmployeeNotFoundExtсeption {
        int index = indexOf(employee);
        if (index != -1) {
            Employee result = employees[index];
            System.arraycopy(employee, index + 1, employee, index, size - index);
            size--;
            return result;
        }
        throw new EmployeeNotFoundExtсeption();
    }

    @Override
    public Employee find(String firstname, String lastname) throws EmployeeNotFoundExtсeption {
        Employee newEmployee = new Employee(firstname, lastname);
        int index = indexOf(newEmployee);
        if (index != -1) {
            return employees[index];
        }

        throw new EmployeeNotFoundExtсeption();
    }

    private int indexOf(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                return i;
            }
        }
        return -1;
    }




}
