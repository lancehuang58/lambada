package idv.lance;

import java.util.function.Function;

public class DecoratorExample {

    public static void main(String[] args) {
        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;
        //increment and double
        //int temp = inc.apply(5);
        //System.out.println(doubleIt.apply(temp));
        doWork(5, inc);
        doWork(5, doubleIt);
        doWork(5, inc.andThen(doubleIt));
    }


    public static void doWork(int value, Function<Integer, Integer> fun) {
        System.out.println(fun.apply(value));
    }
}
