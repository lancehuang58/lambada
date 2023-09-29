package idv.lance.streams;

import static java.util.stream.IntStream.range;

public class Repeat {
    public static void repeat(int n, Runnable runnable) {
        range(0, n).forEach(i -> runnable.run());
    }
}
