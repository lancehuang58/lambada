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
	TwoArgs twoArgs = This::two;
    twoArgs.call2(new This(), 2, 2.0);
  }

}
