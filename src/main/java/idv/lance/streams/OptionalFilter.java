package idv.lance.streams;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class OptionalFilter {
    static final String[] elements = {"Foo", "", "Bar", "Baz", "Bingo"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String desc, Predicate<String> predicate) {
        System.out.println("desc = " + desc);
        for (int i = 0; i < elements.length; i++) {
            System.out.println(testStream().skip(i).filter(predicate).findFirst());
        }
    }

    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
    }
}
