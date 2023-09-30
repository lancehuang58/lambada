package idv.lance.streams;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Random;
import java.util.stream.Stream;

@ToString
@Getter
@RequiredArgsConstructor
class Frobnitz {
    final int size;
    static Random random = new Random(47);
    static final int BOUND = 100;

    static Frobnitz supply() {
        return new Frobnitz(random.nextInt(BOUND));
    }
}

public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
              .limit(20)
              .peek(i -> System.out.println("#" + i))

              .reduce((f1, f2) -> f1.getSize() < 50 ? f1 : f2)
              .ifPresent(System.out::println);
    }
}
