package idv.lance.onjava;

import java.util.function.IntSupplier;

public class Closure5 {

  IntSupplier makeFun(int x) {
	int i = 0;
	i++;
	x++;
//	return () -> 1 + i + x; //cannot compile
	return () -> 0;
  }
}
