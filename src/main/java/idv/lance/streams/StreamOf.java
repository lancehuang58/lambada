package idv.lance.streams;

import java.util.stream.Stream;

public class StreamOf {
    public static void main(String[] args) {
        showRespect();
        showRespect();
        System.out.println("1");
        System.out.println("2");


        Stream.of(new Bubble(1), new Bubble(2), new Bubble(3), new Bubble(4)).forEach(System.out::println);
        Stream.of("It's ", "a", "wonderful", "world").forEach(System.out::println);
        Stream.of(3.14, 2.7, 1.88).forEach(System.out::println);
    }

    public static void showRespect() {
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
    }
}
