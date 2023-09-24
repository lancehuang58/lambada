package idv.lance.onjava;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntSupplier;

@Slf4j
public class Closure1 {
  int i;

  IntSupplier makeFun(int x) {
	return () -> x + i++;
  }
}
