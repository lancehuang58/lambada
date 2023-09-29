package idv.lance.streams;

import org.apache.commons.lang3.Validate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWordsRegexp {
    private final String all;

    public FileToWordsRegexp(String fname) {
        try (InputStream is = getClass().getResourceAsStream(fname)) {
            Validate.notNull(is, "file cannot be read");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            all = reader.lines().skip(1).collect(Collectors.joining(" "));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<String> stream(){
        return Pattern.compile("[ ,.?]+").splitAsStream(all);
    }

    public static void main(String[] args) {
        FileToWordsRegexp fw = new FileToWordsRegexp("/Cheese.dat");
        fw.stream().limit(7).map(w -> w + " ").forEach(System.out::print);
        System.out.println();
        fw.stream().limit(2).map(w -> w + " ").forEach(System.out::print);
    }
}
