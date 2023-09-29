package idv.lance.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Generator implements Supplier<String> {
    Random random = new Random(47);
    char[] words = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String get() {
        return "" + words[random.nextInt(words.length)];
    }

    public static void main(String[] args) {
        String joinString = Stream.generate(new Generator()).limit(10).collect(Collectors.joining(","));
        System.out.println("joinString = " + joinString);
    }
}
