package idv.lance.collector;



import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Data {
    public static Supplier<List<Person>> PERSON_SUPPLIER = () ->
        Arrays.asList(
            Person.of("Sara", 22),
            Person.of("Bob", 20),
            Person.of("Sara", 20),
            Person.of("Paul", 32),
            Person.of("Jack", 3),
            Person.of("Paula", 32),
            Person.of("Jack", 72),
            Person.of("Jill", 11));

}
