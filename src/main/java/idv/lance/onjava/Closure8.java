package idv.lance.onjava;

import java.util.function.IntSupplier;

public class Closure8 {

  IntSupplier makeFun(int x) {

	int i = 0;

	return new IntSupplier() {
	  @Override
	  public int getAsInt() {
		return x + i;
	  }
	};
  }
}
