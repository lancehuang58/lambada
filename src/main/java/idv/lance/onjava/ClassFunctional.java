package idv.lance.onjava;


import lombok.ToString;
@ToString
class AA{}
@ToString
class BB{}
@ToString
class CC{}

public class ClassFunctional {
  static AA f1() {return new AA();}
  static int f2(AA a1, AA a2) {return 1;}
  static void f3(AA aa) {System.out.println("f3 = " + aa);}
  static void f4(AA aa, BB bb) {System.out.println("aa = " + aa); System.out.println("bb = " + bb);}
  static CC f5(AA bb) {return new CC();}
  static CC f6(AA a, BB b) {return new CC();}
  static boolean f7(AA a) {return true;}
  static boolean f8(AA a, BB bb) {return true;}
  static AA f9(AA a) {return a;}
  static AA f10(AA a, AA b) {return b;}

  public static void main(String[] args) {






  }

}
