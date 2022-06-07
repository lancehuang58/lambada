package idv.lance;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DepartmentTest {

    @Test
    void dept_init() {
        Department dept = Department.builder().name("finance").build();
        log.info("dept {}", dept);
    }
}
