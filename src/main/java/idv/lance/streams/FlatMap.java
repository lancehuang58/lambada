package idv.lance.streams;

import java.util.List;
import java.util.stream.Stream;

public class FlatMap {
    public static void main(String[] args) {
        List<String> list = Stream.of(1, 2, 3)
                                  .flatMap(i -> Stream.of("A", "B", "C"))
                                  .toList();
        System.out.println("list = " + list);
    }
}
