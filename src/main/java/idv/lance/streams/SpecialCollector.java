package idv.lance.streams;

import lombok.var;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class SpecialCollector {
    public static void main(String[] args) throws IOException {
        try (InputStream is = FileToWords.class.getResourceAsStream("/Cheese.dat")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            var collect = reader.lines().collect(ArrayList::new, ArrayList::add,
                ArrayList::addAll);
            System.out.println("collect = " + collect);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
