package idv.lance.collector;

import org.junit.jupiter.api.Test;

import java.util.List;

class PeopleProviderTest {

    @Test
    void test_people_age_sum_reduce() {
        List<Person> people = PeopleProvider.get();

        //int ageTotal = people.stream().map(Person::getAge).reduce(0, (total, age) -> total + age);
        int ageTotal = people.stream().map(Person::getAge).reduce(0, Integer::sum);

        System.out.println(ageTotal);
    }
}