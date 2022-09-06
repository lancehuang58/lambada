package idv.lance;

import idv.lance.collector.Person;

import java.util.List;
import java.util.function.Supplier;

public class Data {
    public static Supplier<List<Person>> personSupplier = () ->
            List.of(
                    Person.of("Bill", 22),
                    Person.of("Sara", 20),
                    Person.of("Bob", 20),
                    Person.of("Paula", 32),
                    Person.of("Paul", 32),
                    Person.of("Jack", 3),
                    Person.of("Jean", 72),
                    Person.of("Jill", 11));
}
