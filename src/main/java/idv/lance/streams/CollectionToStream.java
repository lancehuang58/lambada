package idv.lance.streams;

import java.util.List;

public class CollectionToStream {
    public static void main(String[] args) {
        var bubbles = List.of(new Bubble(1), new Bubble(2), new Bubble(3));
        int r = bubbles.stream().mapToInt(Bubble::getI).sum();
        System.out.println(r);
    }
}
