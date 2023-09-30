package idv.lance.streams;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Optionals {

    static void basics(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("nothing inside.");
        }
    }

    static void test(String name, Consumer<Optional<String>> cos) {
        System.out.println("===" + name + "===");
        cos.accept(Stream.of("Episode").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    static void ifPresent(Optional<String> optionalS) {
        optionalS.ifPresent(System.out::println);
    }

    static void orElse(Optional<String> optional) {
        System.out.println(optional.orElse("Nada"));
    }

    static void orElseGet(Optional<String> optional) {
        System.out.println(optional.orElseGet(() -> "Generated"));
    }

    static void orElseThrow(Optional<String> optional) {
        try {
            optional.orElseThrow(RuntimeException::new);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        test("basics", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
