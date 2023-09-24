package idv.lance.onjava;

import org.junit.jupiter.api.Test;

import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.*;

class Closure6Test {

  @Test
  void test() {
	Closure6 closure6 = new Closure6();
	IntSupplier intSupplier = closure6.makeFun(1);
	System.out.println("intSupplier.getAsInt() = " + intSupplier.getAsInt());
	System.out.println("intSupplier.getAsInt() = " + intSupplier.getAsInt());
	System.out.println("intSupplier.getAsInt() = " + intSupplier.getAsInt());

  }
}