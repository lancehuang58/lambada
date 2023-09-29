package idv.lance.streams;

import org.apache.commons.lang3.Validate;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWordsBuilder {

    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String name) {
        try (InputStream is = getClass().getResourceAsStream(name)) {
            Validate.notNull(is, "file not found " + name);

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            reader.lines()
                  .skip(1)
                  .map(s -> s.split("[ .,?]+"))
                  .flatMap(Arrays::stream)
                  .forEach(builder::add);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) {
        String join =
            new FileToWordsBuilder("/Cheese.dat1").stream().limit(7).collect(Collectors.joining(","));
        System.out.println("join = " + join);
    }
}
