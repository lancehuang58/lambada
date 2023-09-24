package idv.lance.onjava;

import java.util.function.Function;

class One {}

class Two {}

public class ConsumeFunction {
  static Two consume(Function<One, Two> fun) {
    return fun.apply(new One());
  }

  public static void main(String[] args) {
    Two two = consume(one -> new Two());
  }
}
