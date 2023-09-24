package idv.lance.onjava;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@ToString
class I {
}

@ToString
class O {
}

@Slf4j
public class TransformFunction {

  static Function<I, O> transform(Function<I, O> in) {
	return in.andThen(o -> {
	  log.info("and then :: o {}", o.toString());
	  return o;
	});
  }

  public static void main(String[] args) {
	Function<I, O> f2 = transform(i -> {
	  log.info("first fun:: i {}", i.toString());
	  return new O();
	});

	O apply = f2.apply(new I());
	System.out.println("apply = " + apply);
  }
}
