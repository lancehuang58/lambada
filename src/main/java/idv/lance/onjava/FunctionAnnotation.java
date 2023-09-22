package idv.lance.onjava;

@FunctionalInterface
interface Functional {
  String goodbye(String name);
}

interface FunctionalNoAnn {
  String goodbye(String name);
}


public class FunctionAnnotation {
  public String goodbye(String name) {
	return "Goodbye " + name;
  }

  public static void main(String[] args) {
	FunctionAnnotation fa = new FunctionAnnotation();
	Functional f = fa::goodbye;
	System.out.println("f.goodbye(\"Lance\") = " + f.goodbye("Lance"));
	FunctionalNoAnn fna = fa::goodbye;
	System.out.println("fna.goodbye(\"Lance\") = " + fna.goodbye("Lance"));
  }
}
