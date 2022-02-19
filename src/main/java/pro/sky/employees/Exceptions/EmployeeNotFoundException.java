package pro.sky.employees.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Throwable {


    public EmployeeNotFoundException(String s) {
        super("Такого нет");
    }

    public EmployeeNotFoundException() {

    }

}
