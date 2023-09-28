package idv.lance.streams;

import java.util.Random;
import java.util.stream.Stream;

public class RandomGenerators {

    public static <T> void show(Stream<T> stream) {
        stream.limit(4).forEach(System.out::println);
        System.out.println("+++++++++++++++");
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        show(rand.ints().boxed());
        show(rand.longs().boxed());
        show(rand.doubles().boxed());

        show(rand.ints(10,20).boxed());
        show(rand.longs(50, 100).boxed());
        show(rand.doubles(20, 30).boxed());

        show(rand.ints(2).boxed());
        show(rand.longs(2).boxed());
        show(rand.doubles(2).boxed());

        show(rand.ints(3, 1, 10).boxed());
        show(rand.longs(3, 10, 15).boxed());
        show(rand.doubles(3, 1.0, 20.0).boxed());
    }
}
