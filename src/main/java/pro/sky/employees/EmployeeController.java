package pro.sky.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String greeting () {
        return "Добро пожаловать в книгу учёта!";
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstname, @RequestParam String lastname)  {
        Employee result = employeeService.add(firstname,lastname);
        return generateMessage(result, "Создан");
    }
    @GetMapping("/remove")
    public String remove(@RequestParam String firstname, @RequestParam String lastname)  {
        Employee result = employeeService.remove(firstname,lastname);
        return generateMessage(result, "Удалён");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstname, @RequestParam String lastname)  {
        return employeeService.find(firstname,lastname);
    }


    private String generateMessage(Employee employee, String status) {

        return String.format("Сотрудник %s %s %s.", employee.getLastName(), employee.getLastName(), status);
    }

}
