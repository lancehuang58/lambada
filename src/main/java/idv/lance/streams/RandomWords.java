package idv.lance.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomWords implements Supplier<String> {

    Random rand = new Random(47);
    List<String> words = new ArrayList<>();

    public RandomWords(String fname) {
        InputStream is = RandomWords.class.getResourceAsStream(fname);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> lines = reader.lines().collect(Collectors.toList());
        words = lines.subList(1, lines.size())//skip first line
                     .stream()
                     .map(s -> s.split("[ .?,]+"))//split by ' ',?,.
                     .flatMap(Arrays::stream)
                     .collect(Collectors.toList());
//        for (String line : lines.subList(1, lines.size())) {
//            for (String s : line.split("[ .?,]+")) {
//                words.add(s.toLowerCase());
//            }
//        }
    }

    @Override
    public String toString() {
        return String.join(" ", words);
    }

    public static void main(String[] args) throws IOException {
        RandomWords randomWordsSupplier = new RandomWords("/Cheese.dat");
        String result = Stream.generate(randomWordsSupplier)
                              .limit(20)
                              .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    @Override
    public String get() {
        return words.get(rand.nextInt(words.size()));
    }
}
