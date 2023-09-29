package idv.lance.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamOfRandoms {
    static Random random = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
              .flatMapToInt(i -> IntStream.concat(
                  random.ints(0, 100)
                        .limit(i), IntStream.of(-1)))
              .forEach(n -> System.out.printf("%d ", n));
    }
}
