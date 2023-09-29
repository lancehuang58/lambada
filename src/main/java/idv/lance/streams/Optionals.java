package idv.lance.streams;

import idv.lance.onjava.ConsumeFunction;

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

    public static void main(String[] args) {
        test("basics", Optionals::basics);
    }
}
