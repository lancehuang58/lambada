package idv.lance.onjava;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PredicateComposition {
  static IntPredicate p1 = s -> s == 2,
	  p2 = s -> s < 5,
	  p3 = s -> s % 2 != 0,
	  p4 = p1.negate().and(p2).and(p3);

  public static void main(String[] args) {
	IntStream.range(1,10).filter(p4).forEach(System.out::println);
  }
}
