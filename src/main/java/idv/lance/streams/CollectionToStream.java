package idv.lance.streams;


import static java.util.Arrays.asList;

public class CollectionToStream {
    public static void main(String[] args) {
        var bubbles = asList(new Bubble(1), new Bubble(2), new Bubble(3));
        int r = bubbles.stream().mapToInt(Bubble::getI).sum();
        System.out.println(r);
    }
}
