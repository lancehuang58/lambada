package idv.lance.onjava;

import java.util.function.Function;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
class Content1{
  String name;
  long time;
  String id;
}




public class Currying {

  static final Function<String, Function<String, String>> fun1 = a -> b -> a + b;

  public static void main(String[] args) {
    System.out.println("fun1.apply(\"1\").apply(\"2\") = " + fun1.apply("1").apply("2"));
  }
}
