package idv.lance;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class StrategyExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(totalValue(numbers, i -> true));
        System.out.println(totalValue(numbers, Util::isEven));
        System.out.println(totalValue2(numbers, Util::isOdd));
    }

    public static Integer totalValue(Collection<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream().filter(selector).reduce(0, Integer::sum);
    }

    public static Integer totalValue2(Collection<Integer> numbers, Predicate<Integer> selector) {
        return numbers.stream().filter(selector).mapToInt(i -> i).sum();
    }
}

class Util {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
