package idv.lance.streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class FunctionMap {
    static final String[] elements = {"12", "13", "", "23", "43", "17", ""};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String description, Function<String, String> function) {
        System.out.printf("----------------(%s)----------------\n", description);
        testStream().map(function).forEach(System.out::println);
    }

    public static void main(String[] args) {
        test("add brackets", s -> String.format("[%s]", s));

        test("increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (Exception e) {
                return s;
            }
        });

        test("Replace", s -> s.replace("2", "9"));

        test("take last digit", s -> s.length() > 0 ? s.charAt(s.length() - 1) +
            "" : s);

    }
}
