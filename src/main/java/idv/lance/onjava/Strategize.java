package idv.lance.onjava;

import java.util.function.Function;

interface Strategy {
  String approach(String message);
}

class Soft implements Strategy {
  @Override
  public String approach(String message) {
	return message.toLowerCase() + "?";
  }
}

class Unrelated {
  static String twice(String msg) {
	return msg + " " + msg;
  }
}

class Test {
  static String mytest(String msg) {
	return "";
  }
}

public class Strategize {

  static Function<String, String> fun = str -> str +  ">>> ";

  String msg;
  Strategy strategy;

  public Strategize(String msg) {
	this.msg = msg;
	strategy = new Soft();
  }

  void communicate() {
	System.out.println("strategy.approach(msg) = " + strategy.approach(msg));
  }

  void changeStrategy(Strategy strategy) {
	this.strategy = strategy;
  }

  public static void main(String[] args) {
	Strategy[] strategies = {new Strategy() {
	  @Override
	  public String approach(String message) {
		return message.toUpperCase();
	  }
	}, msg -> msg.substring(0, 5), Unrelated::twice};
	Strategize s = new Strategize("Hello There");
	s.communicate();
	for (Strategy strategy : strategies) {
	  s.changeStrategy(strategy);
	  s.communicate();
	}
  }


}
