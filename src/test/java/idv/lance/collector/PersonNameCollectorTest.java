package idv.lance.collector;

import org.junit.jupiter.api.Test;

import java.util.List;

class PersonNameCollectorTest {

    @Test
    void test() {
        List<String> nameList = Data.PERSON_SUPPLIER.get().stream().collect(new PersonNameCollector());
        System.out.println("collect = " + nameList);
    }
}