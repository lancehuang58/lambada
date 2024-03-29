package idv.lance.collector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class PersonNameCollector implements Collector<Person, List<String>, List<String>> {

    @Override
    public Supplier<List<String>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<String>, Person> accumulator() {
        return (l,p)-> l.add(p.getName());
    }

    @Override
    public BinaryOperator<List<String>> combiner() {
        return (a,b)-> {
            a.addAll(b);return a;
        };
    }

    @Override
    public Function<List<String>, List<String>> finisher() {
        return Collections::unmodifiableList;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
