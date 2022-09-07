package idv.lance.collector;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static idv.lance.Data.PERSON_SUPPLIER;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class PeopleProviderTest {


    //reduce takes the collection reduces to a single value...
    //reduces convert a stream to something concrete.
    //java has reduces in two forms, reduce and collect
    @Test
    void test_people_age_sum_reduce() {
        List<Person> people = PERSON_SUPPLIER.get();
        //int ageTotal = people.stream().map(Person::getAge).reduce(0, (total, age) -> total + age);
        int ageTotal = people.stream().map(Person::getAge).reduce(0, Integer::sum);
        assertEquals(212, ageTotal);
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
        List<String> collect = PERSON_SUPPLIER.get().stream()
                .filter(p -> p.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                //reduce including 3 params
                .reduce(new ArrayList<>(), //1. container for element
                        (names, name) ->   //2.accumulator how to handle each element and merge to init value
                        {
                            names.add(name);
                            return names;
                        }, (names1, names2) ->  //3.combiner, if the stream running in parallel stream , how the 2 different collection to merge.
                        {
                            names1.addAll(names2);
                            return names1;
                        });
        assertIterableEquals(List.of("PAULA", "PAUL", "JACK"), collect);
    }

    /**
     * map object to int stream and using function to aggregate.
     */
    @Test
    void test_int_stream() {
        int sum = PERSON_SUPPLIER.get().stream().mapToInt(Person::getAge).sum();
        assertEquals(212, sum);
    }

    @Test
    void test_find_the_max_age_in_collection() {
        //Optional<Person> collect = PERSON_SUPPLIER.get().stream().collect(maxBy(comparing(Person::getAge)));
        Optional<Person> max = PERSON_SUPPLIER.get().stream().max(comparing(Person::getAge));
        max.ifPresent(m -> assertEquals(m.getAge(), 72));
        Optional<Person> min = PERSON_SUPPLIER.get().stream().min(comparing(Person::getAge));
        min.ifPresent(m -> assertEquals(m.getAge(), 3));
    }

    @Test
    void test_find_max_age_person_name() {
        String maxAgeUserName = PERSON_SUPPLIER.get().stream().collect(
                collectingAndThen(
                        maxBy(comparing(Person::getAge)),
                        person -> person.map(Person::getName).orElse("")));
        assertEquals(maxAgeUserName, "Jack");
    }

    @Test
    void test_collector() {
        List<String> collect = PERSON_SUPPLIER.get().stream()
                .filter(p -> p.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        assertIterableEquals(List.of("PAULA", "PAUL", "JACK"), collect);
    }

    @Test
    void test_mapping_user_to_name_and_age_map() {
        Map<String, Integer> nameAndAge = PERSON_SUPPLIER.get()
                .stream().collect(toMap(Person::getName, Person::getAge, (a, b) -> a));
        assertEquals(nameAndAge.size(), 6);
    }

    @Test
    void test_map_ages() {
        List<Integer> ages = PERSON_SUPPLIER.get().stream()
                .map(Person::getAge)
                .collect(toUnmodifiableList());
        assertThrows(UnsupportedOperationException.class, () -> ages.add(1));
    }

    @Test
    void test_get_names_as_string() {
        String joinNames = PERSON_SUPPLIER.get()
                .stream().filter(p -> p.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(Collectors.joining(","));

        assertEquals(joinNames, "PAULA,PAUL,JACK");
    }

    @Test
    void test_partition() {
        Map<Boolean, List<Person>> partitionPerson =
                PERSON_SUPPLIER.get().stream()
                        .collect(partitioningBy(person -> person.getAge() % 2 == 0));
        System.out.println("even age user -> " + partitionPerson.get(true));

    }

    /**
     * group by name , then collect age to list.
     */
    @Test
    void test_group_by_age_and_name() {
        var collect = PERSON_SUPPLIER.get().stream()
                .collect(groupingBy(Person::getName, mapping(Person::getAge, toSet())));
        System.out.println(collect);
    }

    @Test
    void test_count_by_name() {
        Map<String, Long> collect = PERSON_SUPPLIER.get().stream()
                .collect(groupingBy(Person::getName, counting()));
        System.out.println(collect);
    }

    /**
     * 1. group by name
     * 2. each group apply collector counting
     * 3. use collectingAndThen to change the final result.
     */
    @Test
    void test_get_count_as_integer_by_name() {
        Map<String, Integer> collect = PERSON_SUPPLIER.get().stream()
                .collect(
                        groupingBy(Person::getName,
                                collectingAndThen(counting(), Long::intValue)));
        System.out.println(collect);
    }


    @Test
    void use_filtering_to_find_user_name_length_greater_than_4_group_by_name() {
        System.out.println(PERSON_SUPPLIER.get()
                .stream().collect(
                        groupingBy(Person::getAge,
                                mapping(Person::getName,
                                        filtering(name -> name.length() > 4, toList())))));
    }

    @Test
    void flat_mapping() {
        var numbers = List.of(1, 2, 3);
        List<Integer> collect = numbers
                .stream()
                .flatMap(i -> Stream.of(i - 1, i + 1))
                .collect(toList());
        System.out.println(collect);
    }

    @Test
    void test_flatMapping() {
        var collect = PERSON_SUPPLIER.get().stream()
                .collect(
                        groupingBy(Person::getAge,
                                mapping(p -> p.getName().toUpperCase(),
                                        flatMapping(name -> Stream.of(name.split("")), toSet())
                                ))
                );
        System.out.println(collect);
    }
}