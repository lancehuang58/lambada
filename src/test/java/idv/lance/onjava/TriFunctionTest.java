package idv.lance.onjava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriFunctionTest {

  static int f(int i, long l, double d) {
	return (int) (i + l + d);
  }

  @Test
  void test() {
    TriFunction<Integer, Long, Double, Integer> fun = TriFunctionTest::f;
    Integer r = fun.apply(1, 2L, 3.0);
    assertEquals(r, 6);
    System.out.println("r = " + r);
  }
}