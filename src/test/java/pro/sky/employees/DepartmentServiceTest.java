package pro.sky.employees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.employees.Exceptions.EmployeeNotFoundException;
import pro.sky.employees.Service.EmployeeService;
import pro.sky.employees.Service.ServiceImpl.DepartmentServiceImpl;
import java.util.*;
import static pro.sky.employees.EmployeesServiceInvariableTest.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    void setUp() {
        Mockito.when(employeeServiceMock.allEmployees()).thenReturn(List.of(
                new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
                new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_1)
        ));
    }

    @Test
    public void testMinSalary() throws EmployeeNotFoundException {
        Employee actualResult = out.employeeMinSalary(DEPARTMENT_1);
        Employee expectedResult = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testMinSalaryForEmptyDepartment() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.employeeMinSalary(DEPARTMENT_2));
    }

    @Test
    public void testMaxSalary() throws EmployeeNotFoundException {
        Employee actualResult = out.employeeMaxSalary(DEPARTMENT_2);
        Employee expectedResult = new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_2);
        Assertions.assertEquals(expectedResult, actualResult);

    }
    @Test
    public void testMaxSalaryForEmptyDepartment() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.employeeMaxSalary(DEPARTMENT_2));
    }

    @Test
    public void testGetEmployeeForDepartment() {
        Collection<Employee> actual = out.getEmployeesFor(DEPARTMENT_1);
        List<Employee> expected = List.of(
                new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
                new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_1)
        );
        Assertions.assertEquals(expected.size(), actual.size());
        Assertions.assertTrue(expected.containsAll(actual));

    }
    @Test
    public void testGetEmployeeForEmptyDepartment() {
        Collection<Employee> actual = out.getEmployeesFor(DEPARTMENT_2);
        List<Employee> expected = Collections.emptyList();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testGetAllEmployeeByDepartment() {
        Map<Integer, List<Employee>> actual = out.getAllEmployeesDepartment();
        Map<Integer, List<Employee>> expected = Map.of(
                DEPARTMENT_1, List.of(
                        new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
                        new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_1, SALARY_1))
        );
        Assertions.assertEquals(expected, actual);
    }

}
