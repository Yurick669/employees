package pro.sky.employees;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeBookOverflowException extends Throwable {

    public EmployeeBookOverflowException() {
        super ("Переполнено");
    }

}
