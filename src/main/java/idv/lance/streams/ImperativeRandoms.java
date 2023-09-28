package idv.lance.streams;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int e = rand.nextInt(20);
            if (e < 5) {
                continue;
            }
            rints.add(e);
        }
        System.out.println("rints = " + rints);
    }
}
