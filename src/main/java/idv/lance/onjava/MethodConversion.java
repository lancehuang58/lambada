package idv.lance.onjava;

import java.util.function.BiConsumer;

class In1 {
}

class In2 {
}

public class MethodConversion {

  static void accept(In1 i1, In2 in2) {
	System.out.println("accept()");
  }

  static void some(In1 i1, In2 in2) {
	System.out.println("other method");
  }

  public static void main(String[] args) {
	BiConsumer<In1, In2> bc;
	bc = MethodConversion::accept;
	bc.accept(new In1(), new In2());

	bc = MethodConversion::some;
	bc.accept(new In1(), new In2());
  }
}
