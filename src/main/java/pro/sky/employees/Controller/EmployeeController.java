package pro.sky.employees.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employees.Employee;
import pro.sky.employees.Service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping()
    public String greeting () {
        return "Добро пожаловать в книгу учёта!";
    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public String add(@RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam(name = "departmentId", required = false) int department,
                      @RequestParam(required = false) int salary
    )  {
        Employee result = employeeService.add(firstName,lastName, department, salary);
        return generateMessage(result, "- успешно создан");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName)  {
        Employee result = employeeService.remove(firstName,lastName);
        return generateMessage(result, "- удалён");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName)  {
        return employeeService.find(firstName,lastName);
    }

    @GetMapping("/all")
    public Collection<Employee> allEmployees() {
        return (employeeService.allEmployees());
    }

    private String generateMessage(Employee employee, String status) {

        return String.format("Сотрудник: %s %s %s.", employee.getFirstName(), employee.getLastName(), status);
    }

}
