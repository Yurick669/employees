package pro.sky.employees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pro.sky.employees.Exceptions.EmployeeExistsException;
import pro.sky.employees.Exceptions.EmployeeNotFoundException;
import pro.sky.employees.Service.EmployeeService;
import pro.sky.employees.Service.ServiceImpl.EmployeeServiceImpl;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.employees.EmployeesServiceInvariableTest.*;

@SpringBootTest
class EmployeesServiceTests {

	private EmployeeService out;

	@BeforeEach
	void setUp() {
		out = new EmployeeServiceImpl();
	}

	@Test
	void testAdd() {
		Employee actualEmployee = out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		assertEquals(expectedEmployee, actualEmployee);
	}

	@Test
	void testAddEmployee() {
		Employee actualEmployee = out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		assertEquals(expectedEmployee, actualEmployee);
		actualEmployee = out.add(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
		expectedEmployee = new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
		assertEquals(expectedEmployee, actualEmployee);
	}

	@Test
	public void testDuplicate() {
		out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		Assertions.assertThrowsExactly(EmployeeExistsException.class, () -> out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1));
	}

	@Test
	void testRemoveAddEmployee () throws EmployeeNotFoundException {
		out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		Employee actualEmployee = out.remove(FIRST_NAME_1, LAST_NAME_1);
		Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		assertEquals(expectedEmployee, actualEmployee);

	}
	@Test
	void testRemoveNoAddEmployee() {
		Assertions.assertThrowsExactly(EmployeeExistsException.class, () -> out.remove(FIRST_NAME_1, LAST_NAME_1));
	}
	@Test
	void testFindAddEmployee() throws EmployeeNotFoundException {
		out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		Employee actualEmployee = out.find(FIRST_NAME_1, LAST_NAME_1);
		Employee expectedEmployee = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		assertEquals(expectedEmployee, actualEmployee);
	}

	@Test
	void testFindNoAddEmployee() {
		Assertions.assertThrowsExactly(EmployeeExistsException.class, () -> out.find(FIRST_NAME_1, LAST_NAME_1));

	}
	@Test
	void testAllEmployee() {
		out.add(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1);
		out.add(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2);
		Collection<Employee> actual = out.allEmployees();
		List<Employee> expected = List.of(
				new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_1, SALARY_1),
				new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_2, SALARY_2)
		);
		assertEquals(actual.size(), expected.size());
		Assertions.assertTrue(expected.containsAll(actual));


	}



}
