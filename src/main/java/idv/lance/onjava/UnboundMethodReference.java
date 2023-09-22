package idv.lance.onjava;

class X {
  String f() {
	return "X::f";
  }
}

interface MakeString {
  String make();
}

interface TransformX {
  String tranform(X x);
}

public class UnboundMethodReference {
  public static void main(String[] args) {
//	MakeString ms = X::f;
	TransformX sp = X::f;
	System.out.println(sp.tranform(new X()));
  }
}
