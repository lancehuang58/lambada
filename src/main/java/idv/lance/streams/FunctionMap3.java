package idv.lance.streams;

import java.util.stream.Stream;

public class FunctionMap3 {
    public static void main(String[] args) {
        Stream.of("3", "5", "7")
              .mapToInt(Integer::parseInt)
              .forEach(d -> System.out.printf("%d\t", d));
        System.out.println();

    }
}
