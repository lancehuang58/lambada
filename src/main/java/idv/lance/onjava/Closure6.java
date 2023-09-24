package idv.lance.onjava;

import java.util.function.IntSupplier;

public class Closure6 {

  IntSupplier makeFun(int x) {
	int i = 0;
	i++;
	x++;
	final int ii = i;
	final int jj = x;
	return () -> ii + jj;
  }
}
