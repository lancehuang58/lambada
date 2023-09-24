package idv.lance.onjava;

import java.util.function.IntSupplier;

public class Closure3 {

  IntSupplier makeFun(final int x) {
	final int i = 0;
	return () -> x + i;
  }
}
