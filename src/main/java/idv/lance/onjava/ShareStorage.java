package idv.lance.onjava;

import java.util.function.IntSupplier;

public class ShareStorage {
  public static void main(String[] args) {
	Closure1 c = new Closure1();
	IntSupplier f1 = c.makeFun(0);
	IntSupplier f2 = c.makeFun(0);
	IntSupplier f3 = c.makeFun(0);
	System.out.println("f1.getAsInt() = " + f1.getAsInt());
	System.out.println("f2.getAsInt() = " + f2.getAsInt());
	System.out.println("f3.getAsInt() = " + f3.getAsInt());

  }
}
