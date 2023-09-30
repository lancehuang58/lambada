package idv.lance.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.String.format;

@Slf4j
public class OptionalFlatmap {

    public static final String[] elements = {"1", "2", "3", "4", "5", "6"};

    static Stream<String> testStream() {
        return Stream.of(elements);
    }

    static void test(String desc, Function<String, Optional<String>> func) {
        log.info("({})\n", desc);
        for (int i = 0; i < elements.length; i++) {
            testStream().skip(i).findFirst().flatMap(func)
                        .ifPresent(log::info);
        }
    }

    //    test
    public static void main(String[] args) {
        test("add brackets", s -> Optional.of(format("(%s)", s)));
        test("increment", s -> {
            try {
                return Optional.of(Integer.parseInt(s) + 1 + "");
            } catch (Exception e) {
                return Optional.ofNullable(s);
            }
        });

    }
}
