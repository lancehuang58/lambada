package idv.lance.onjava;

class This {
  void two(int i, double d) {
  }

  void three(int i, double d, String s) {
  }

  void four(int i, double d, String s, char c) {
  }
}

interface TwoArgs {
  void call2(This athis, int i, double d);
}

interface ThreeArgs {
  void call3(This athis, int i, double d, String s);
}

interface FourArgs {
  void call4(This athis, int i, double d, String s, char c);
}

public class MultiUnbound {

  public static void main(String[] args) {
	TwoArgs twoArgs1 = (athis, i, d) -> {};
	twoArgs1.call2(new This(), 1, 2.0);

	TwoArgs twoArgs = This::two;
	twoArgs.call2(new This(), 2, 2.0);

	ThreeArgs threeArgs = This::three;
	threeArgs.call3(new This(), 1, 2.0, "");

	FourArgs fourArgs = This::four;
	fourArgs.call4(new This(), 1, 3.0, "", 'x');
  }

}
