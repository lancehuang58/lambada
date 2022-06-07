package idv.lance;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class EmployeeTest {
    @Test
    void compare_employee() {

        Employee employee =
                Employee.builder().age(1).name("lance").department(new Department("", "ap")).build();
        Employee employee2 =
                Employee.builder().age(1).name("lance").department(new Department("", "ap")).build();
        Assertions.assertEquals(employee, employee2);
    }

    @Test()
    void npe_throw() {
        Assertions.assertThrows(NullPointerException.class, () -> Employee.builder().build());
    }
}
