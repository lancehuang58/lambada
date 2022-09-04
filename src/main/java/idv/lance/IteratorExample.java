package idv.lance;

import java.util.Arrays;
import java.util.Collection;

public class IteratorExample {

    public static void main(String[] args) {
        demo(Arrays.asList(1, 2, 3, 4, 5));
    }

    public static void demo(Collection<Integer> collection) {
        collection.forEach(System.out::println);
    }
}
