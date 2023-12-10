package idv.lance.streams;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.var;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@ToString
@Getter
@RequiredArgsConstructor
class Pair {
    private final Character c;
    private final Integer i;
}

class RandomPair {
    static Random rand = new Random(47);
    Iterator<Character> capChars = rand.ints(65, 91)
                                       .mapToObj(i -> (char) i)
                                       .iterator();

    public Stream<Pair> stream() {
        return rand.ints(100, 1000)
                   .distinct().mapToObj(i -> new Pair(capChars.next()
                , i));
    }
}

public class MapCollectors {
    public static void main(String[] args) {
        var collect = new RandomPair().stream().limit(8)
                                      .collect(toMap(Pair::getC, Pair::getI, (a, b) -> a));
        System.out.println("collect = " + collect);
    }
}
