package idv.lance.collector;

import java.util.List;

public class PeopleProvider {
    static List<Person> get() {
        return List.of(Person.of("Sara", 22),
                Person.of("Sara", 20),
                Person.of("Bob", 20),
                Person.of("Paula", 32),
                Person.of("Paul", 32),
                Person.of("Jack", 3),
                Person.of("Jack", 72),
                Person.of("Jill", 11)
        );
    }
}
