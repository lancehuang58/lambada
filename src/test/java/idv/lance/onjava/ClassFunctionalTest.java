package idv.lance.onjava;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassFunctionalTest {

  @Test
  void supplier() {
	Supplier<AA> s1 = ClassFunctional::f1;
	System.out.println("s1.get() = " + s1.get());
  }

  @Test
  void comparator() {
	Comparator<AA> c = ClassFunctional::f2;
	System.out.println(c.compare(new AA(), new AA()));
  }

  @Test
  void function() {
	Function<AA, CC> fun = ClassFunctional::f5;
	AA a = new AA();
	System.out.println("aa = " + a);
	CC cc = fun.apply(a);
	System.out.println("cc = " + cc);
  }

  @Test
  void consumer() {
	Consumer<AA> cons = ClassFunctional::f3;
	cons.accept(new AA());
  }

  @Test
  void bi_consumer() {
	BiConsumer<AA, BB> biCon = ClassFunctional::f4;
	biCon.accept(new AA(), new BB());
  }

  @Test
  void bi_function() {
	BiFunction<AA, BB, CC> bif = ClassFunctional::f6;
	CC cc = bif.apply(new AA(), new BB());
	System.out.println("cc = " + cc);
  }

  @Test
  void predicate() {
	Predicate<AA> p = ClassFunctional::f7;
	assertTrue(p.test(new AA()));
  }

  @Test
  void bi_predicate() {
	BiPredicate<AA, BB> bip = ClassFunctional::f8;
	assertTrue(bip.test(new AA(), new BB()));
  }

  @Test
  void operator() {
	UnaryOperator<AA> up = ClassFunctional::f9;
	AA src = new AA();
	AA aa = up.apply(src);
	assertEquals(aa, src);
  }

  @Test
  void bi_operator() {
	BinaryOperator<AA> binaryOperator = ClassFunctional::f10;
	AA a1 = new AA();
	AA a2 = new AA();
	AA target = binaryOperator.apply(a1, a2);
	assertEquals(a2, target);
  }
}