package idv.lance.collector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PeopleProviderTest {


    //reduce takes the collection reduces to a single value...
    //reduces convert a stream to something concrete.
    //java has reduces in two forms, reduce and collect
    @Test
    void test_people_age_sum_reduce() {
        List<Person> people = PeopleProvider.get();
        //int ageTotal = people.stream().map(Person::getAge).reduce(0, (total, age) -> total + age);
        int ageTotal = people.stream().map(Person::getAge).reduce(0, Integer::sum);
        Assertions.assertEquals(212, ageTotal);
    }


}