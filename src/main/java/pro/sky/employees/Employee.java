package pro.sky.employees;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object i) {
        if (this == i) return true;
        if (!(i instanceof Employee)) return false;
        Employee employee = (Employee) i;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName);
    }
    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s", lastName, firstName);
    }
}
