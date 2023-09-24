package idv.lance.onjava;

import java.util.function.Function;

public class CurryingAndPartials {
  static String uncurried(String a, String b) {
	return a + b;
  }

  public static void main(String[] args) {
	Function<String, Function<String, String>> sum = a -> b -> a + b;
	System.out.println(uncurried("Hi ", "Jack"));
	System.out.println("sum.apply(\"Hi \").apply(\"Jack\") = " + sum.apply("Hi ").apply("Jack"));
  }
}
