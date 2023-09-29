package idv.lance.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWords {

    public static final Pattern PATTERN = Pattern.compile("\\W+");

    public static Stream<String> stream(String file) throws IOException {
        try (InputStream is = FileToWords.class.getResourceAsStream(file)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            Stream<String> lines = reader.lines();
            return lines.skip(1)
                        .flatMap(s-> Arrays.stream(s.split("\\W+")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
//        String s = FileToWords.stream("/Cheese.dat").limit(3).collect(Collectors.joining(","));
//        System.out.println("s = " + s);
        Stream<String> stream = FileToWords.stream("/Cheese.dat");
        System.out.println(stream.collect(Collectors.joining()));
    }
}
