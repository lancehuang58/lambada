package idv.lance.onjava;

import java.util.function.Function;

interface Funcss extends Function<String, String> {}

public class ProduceFunction {
  static Funcss produce() {
    return String::toLowerCase;
  }
  public static void main(String[] args){
    Funcss fun = produce();
    String yellow = fun.apply("yEAR");
    System.out.println("yellow = " + yellow);
  }
}
