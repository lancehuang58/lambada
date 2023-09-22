package idv.lance.onjava;


interface Callable {
  void call(String s);
}

class Describe {
  void show(String msg) {
	System.out.printf("Desc.show > %s\n", msg);
  }
}


public class MethodReferences {
  static void hello(String name) {
	System.out.printf("MethodReferences.hello()-> Hello, %s\n", name);
  }

  static class Description {
	String about;

	public Description(String about) {
	  this.about = about;
	}

	void help(String msg) {
	  System.out.println(about + " >>> " + msg);
	}
  }

  static class Helper {
	static void assist(String msg) {
	  System.out.println("assist > " + msg);
	}
  }

  public static void main(String[] args) {
	Describe d = new Describe();
	Callable c = d::show;
	c.call("Lance");

	c = MethodReferences::hello;
	c.call("Lance");

	c = new Description("VIP")::help;
	c.call("Lance");

	c = Helper::assist;
	c.call("Lance");
  }
}
