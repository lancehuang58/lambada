package idv.lance.streams;

import org.apache.commons.lang3.Validate;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class TreeSetOfWords {

    public static void main(String[] args) {
        var file_name = "/Cheese.dat";
        try (InputStream is = TreeSetOfWords.class.getResourceAsStream(file_name)) {
            Validate.notNull(is, "cannot read file");
            var reader = new BufferedReader(new InputStreamReader(is));
            var list =
                reader.lines()
                      .skip(1)
                      .flatMap(s -> stream(s.split("[ .,?]")))
                      .filter(s -> s.length() > 2)
                      .limit(100)
                      .collect(Collectors.toCollection(TreeSet::new));
            System.out.println("list = " + list);
        } catch (IOException e) {e.printStackTrace();}

    }
}
