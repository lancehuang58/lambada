package idv.lance.collector;

import idv.lance.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class PeopleProviderTest {


    //reduce takes the collection reduces to a single value...
    //reduces convert a stream to something concrete.
    //java has reduces in two forms, reduce and collect
    @Test
    void test_people_age_sum_reduce() {
        List<Person> people = Data.personSupplier.get();
        //int ageTotal = people.stream().map(Person::getAge).reduce(0, (total, age) -> total + age);
        int ageTotal = people.stream().map(Person::getAge).reduce(0, Integer::sum);
        Assertions.assertEquals(212, ageTotal);
    }

    //function programming::
    //function composition + lazy evaluation.
    //lazy evaluation requires purity of function.
    //pure function returns the same result any number of times.
    //we call it with the same input -> idempotency.
    //pure function don't have side effect:
    //1. pure function do not change anything.
    //2. pure function do not depend on anything that may change

    @Test
    void test_reduce1() {
        List<String> collect = Data.personSupplier.get().stream()
                .filter(p -> p.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                //reduce including 3 params
                .reduce(
                        new ArrayList<>(), //1. container for element
                        (names, name) ->   //2.accumulator how to handle each element and merge to init value
                        {
                            names.add(name);
                            return names;
                        },
                        (names1, names2) ->  //3.combiner, if the stream running in parallel stream , how the 2 different collection to merge.
                        {
                            names1.addAll(names2);
                            return names1;
                        });
        Assertions.assertIterableEquals(List.of("PAULA", "PAUL", "JACK"), collect);
    }

    @Test
    void test_collector() {
        List<String> collect = Data.personSupplier.get().stream()
                .filter(p -> p.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        Assertions.assertIterableEquals(List.of("PAULA", "PAUL", "JACK"), collect);
    }
}