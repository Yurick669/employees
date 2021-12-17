package pro.sky.employees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class EmployeeBookOverflowException extends RuntimeException {

    public EmployeeBookOverflowException() {
        super ("Переполнено");
    }

}
