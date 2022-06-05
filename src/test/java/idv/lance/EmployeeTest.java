package idv.lance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void compare_employee() {

        Employee employee = Employee.builder().age(1).name("lance").department(new Department("", "ap")).build();
        Employee employee2 = Employee.builder().age(1).name("lance").department(new Department("", "ap")).build();
        Assertions.assertEquals(employee, employee2);
    }
}