package idv.lance.streams;

import static java.util.stream.IntStream.range;

public class Ranges {
    public static void main(String[] args) {
        int result1 = 0;
        for (int i = 10; i < 20; i++) {
            result1 += i;
        }
        System.out.println("result 1 = " + result1);

        int result2 = 0;
        for(int i: range(10,20).toArray()){
            result2 += i;
        }
        System.out.println("result2 = " + result2);

        System.out.println("result3 = " + range(10, 20).sum());

    }
}
