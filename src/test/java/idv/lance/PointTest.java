package idv.lance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
  @Test
  void test_point() {
    Point a = new Point(1, 2);
    System.out.println(a);
    Point b = a.withX(100);
    Point c = b.withY(200);
    System.out.println(b);
    System.out.println(c);
  }

}