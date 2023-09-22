package idv.lance.onjava;

import lombok.Data;

@Data
class Dog {
  String name;
  int age = -1;

  public Dog() {
	name = "Lucy";
  }

  public Dog(String name) {
	this.name = name;
  }

  public Dog(String name, int age) {
	this.name = name;
	this.age = age;
  }
}

interface MakeNoArgs {
  Dog make();
}

interface MakeOneArgs {
  Dog make(String name);
}

interface MakeTwoArgs {
  Dog make(String name, int age);
}

public class ConstructorReference {
  public static void main(String[] args) {
	MakeNoArgs dogCreation = Dog::new;
	MakeOneArgs dogCreation2 = Dog::new;
	MakeTwoArgs dogCreation3 = Dog::new;

	System.out.println(dogCreation.make().toString());
	System.out.println(dogCreation2.make("Jack").toString());
	System.out.println(dogCreation3.make("Lance", 45).toString());
  }
}
