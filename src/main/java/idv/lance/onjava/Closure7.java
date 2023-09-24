package idv.lance.onjava;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure7 {
  Supplier<List<Integer>> makeFun() {
	final List<Integer> list = new ArrayList<>();
	list.add(1);
	return () -> list;
  }

  public static void main(String[] args) {
	Closure7 c = new Closure7();
	List<Integer> list1 = c.makeFun().get(), list2 = c.makeFun().get();
	list1.add(42);
	list2.add(37);
	System.out.println("list1 = " + list1);
	System.out.println("list2 = " + list2);
  }
}
