package idv.lance.streams;

import static idv.lance.streams.Repeat.repeat;

public class Looping {
    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping"));
        repeat(2, Looping::hi);
    }
}
