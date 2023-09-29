package idv.lance.streams;

import lombok.Getter;
import lombok.ToString;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

@ToString
@Getter
class Nbr {
    final int n;

    public Nbr(int n) {
        this.n = n;
    }
}

public class FunctionMap2 {

    /**
     * map to object
     * @param args
     */
    public static void main(String[] args) {
        range(1, 10).mapToObj(Nbr::new).forEach(System.out::println);
    }
}
