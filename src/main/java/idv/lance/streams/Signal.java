package idv.lance.streams;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;


public record Signal(String msg) {
    static Random random = new Random(47);

    public static Signal morse() {
        return switch (random.nextInt(4)) {
            case 1 -> new Signal("dot");
            case 2 -> new Signal("dash");
            default -> null;
        };
    }

    public static Stream<Optional<Signal>> stream() {
        return Stream.generate(Signal::morse)
                     .map(Optional::ofNullable);
    }
}
