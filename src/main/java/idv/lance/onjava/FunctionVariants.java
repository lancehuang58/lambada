package idv.lance.onjava;

import lombok.ToString;

import java.util.function.*;

@ToString
class Foo {

}

@ToString
class Bar {
  Foo f;

  public Bar(Foo f) {
	this.f = f;
  }
}

@ToString
class IBaz {
  int i;

  public IBaz(int i) {
	this.i = i;
  }
}

@ToString
class LBaz {
  long l;

  public LBaz(long l) {
	this.l = l;
  }
}

@ToString
class DBaz {
  double d;

  public DBaz(double d) {
	this.d = d;
  }
}

public class FunctionVariants {
  static Function<Foo, Bar> f1 = Bar::new;
  //  static Function<Foo, Bar> f1 = f -> new Bar(f);
  static IntFunction<IBaz> f2 = IBaz::new;
  //  static IntFunction<IBaz> f2 = i -> new IBaz(i);
  static LongFunction<LBaz> f3 = LBaz::new;
  //  static LongFunction<LBaz> f3 = l -> new LBaz(l);
  static DoubleFunction<DBaz> f4 = DBaz::new;
  //  static DoubleFunction<DBaz> f4 = d -> new DBaz(d);

  static ToIntFunction<IBaz> f5 = ib -> ib.i;
  static ToLongFunction<LBaz> f6 = lb -> lb.l;
  static ToDoubleFunction<DBaz> f7 = db -> db.d;
  static IntToLongFunction f8 = i -> i;
  static IntToDoubleFunction f9 = i -> i;
  static LongToIntFunction f10 = l -> (int) l;
  static LongToDoubleFunction f11 = l -> (double) l;
  static DoubleToIntFunction f12 = d -> (int) d;
  static DoubleToLongFunction f13 = d -> (long) d;

  public static void main(String[] args) {

    System.out.println("f1.apply(new Foo()) = " + f1.apply(new Foo()));
    System.out.println("f2.apply(1) = " + f2.apply(100));
    System.out.println("f3.apply(1) = " + f3.apply(4234798374L));
    System.out.println("f4.apply(3.5d) = " + f4.apply(3.5d));
    System.out.println("f5.applyAsInt(new IBaz(1)) = " + f5.applyAsInt(new IBaz(1)));
    System.out.println("f6.applyAsLong(new LBaz(3423424L)) = " + f6.applyAsLong(new LBaz(3423424L)));
    System.out.println("f7.applyAsDouble(new DBaz(3.5d)) = " + f7.applyAsDouble(new DBaz(3.5d)));
    long longValue = f8.applyAsLong(100);
    System.out.println("longValue = " + longValue);
    double doubleValue = f9.applyAsDouble(399);
    System.out.println("doubleValue = " + doubleValue);
  }
}
