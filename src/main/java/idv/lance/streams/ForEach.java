package idv.lance.streams;

import lombok.extern.slf4j.Slf4j;

import static idv.lance.streams.RandInts.rands;

@Slf4j
public class ForEach {
    public static void main(String[] args) {
        rands().limit(14).forEach(s -> System.out.printf("%d ", s));
        System.out.println();
        rands().limit(14).parallel().forEach(s -> System.out.printf("%d ", s));
        System.out.println();
        rands().limit(14).parallel().forEachOrdered(s -> System.out.printf("%d ", s));
    }
}
