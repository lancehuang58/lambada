package idv.lance;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
public class IsPalindromePrimeNumber {

    public static void main(String[] args) {

        int a = 1, b = 1000000000;

        List<Integer> prime = new ArrayList<>();
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        int N = b;
        BitSet isPrime = new BitSet();
        isPrime.set(0, true);
        isPrime.set(1, true);

        for (int i = 2; i < N; i++) {

            if (!isPrime.get(i)) {
                prime.add(i);
            }

            for (int j = 0; j < prime.size() && prime.get(j) * i < N; j++) {
                int idx = i * prime.get(j);
                isPrime.set(idx, true);
                if (i % prime.get(j) == 0) {
                    break;
                }
            }
        }

        List<Integer> primes = prime.stream().filter(i -> i != 0).collect(toList());
        System.out.println("primes size " + primes.size());

        List<Integer> primesWithPalindrome = primes.stream()
                .filter(i -> i > a)
                .filter(IsPalindromePrimeNumber::isPalindrome)
                .collect(toList());
        System.out.println("primesWithPalindrome.size() = " + primesWithPalindrome.size());
//        System.out.println(primesWithPalindrome.stream().map(String::valueOf).collect(Collectors.joining(",")));
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("time " + (end - start));
    }

    public static int getDigitsNumber(final int d) {
        return (int) Math.log10(d) + 1;
    }

    public static boolean isPalindrome(int n) {
        return reverse(n) == n;
    }

    public static int reverse(int n) {
        int j = 0;
        int temp = n;
        while (temp != 0) {
            j = j * 10 + temp % 10;
            temp /= 10;
        }
        return j;
    }
}
