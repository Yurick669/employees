package pro.sky.employees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExtсeption extends RuntimeException {

    public EmployeeNotFoundExtсeption() {
        super("Такого нет");
    }

}
