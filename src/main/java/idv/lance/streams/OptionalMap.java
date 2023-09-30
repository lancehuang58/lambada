package idv.lance.streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class OptionalMap {
    static final String[] elements = {"12", "", "14", "15", "16", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String desc, Function<String, String> func) {
        System.out.printf("---- (%s) ----\n", desc);
        for (int i = 0; i < elements.length; i++) {
            testStream().skip(i).findFirst().map(func).ifPresent(System.out::println);
        }
    }

    public static void main(String[] args) {
        test("add brackets", s -> String.format("[%s]", s));
        test("Increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (Exception e) {
                return s;
            }
        });

        test("Replace", s -> s.replace("2", "9"));
        test("take last digit", s -> !s.isEmpty() ? s.charAt(s.length() - 1) + ""
            : s);
    }
}
