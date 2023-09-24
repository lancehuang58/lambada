package idv.lance.onjava;

import java.util.function.Function;

public class FunctionComposition {
  static Function<String, String> f1 = s -> {
	System.out.println(s);
	return s.replace('A', '_');
  }, f2 = s -> s.substring(3), f3 = String::toUpperCase, f4 = f1.compose(f2).andThen(f3);

  public static void main(String[] args) {
	String r = f4.apply("Go After ALL Ambulances");
	System.out.println("r = " + r);
  }

}
