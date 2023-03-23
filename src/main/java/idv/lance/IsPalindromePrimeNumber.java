package idv.lance;

import org.apache.commons.lang3.Range;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class IsPalindromePrimeNumber {
    static Range<Integer> digit8Range = Range.between(10000000, 99999999);
    static Range<Integer> digit6Range = Range.between(100000, 999999);
    static Range<Integer> digit4Range = Range.between(1000, 9999);

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        int N = 1000000000;
        boolean[] isPrime = new boolean[N];
        isPrime[0] = isPrime[1] = true;
        int[] prime = new int[N];
        int t = 0;
        for (int i = 2; i < N; i++) {
            if (!isPrime[i]) {
                prime[t++] = i;
            }

            for (int j = 0; j < t && prime[j] * i < N; j++) {
                int idx = i * prime[j];
                isPrime[idx] = true;
                if (i % prime[j] == 0) break;
            }
        }

        List<Integer> primes = Arrays.stream(prime).filter(i -> i != 0).boxed().collect(toList());
        System.out.println("primes size " + primes.size());
        List<Integer> primesWithPalindrome = primes.stream().filter(IsPalindromePrimeNumber::isPalindrome).collect(toList());
        System.out.println("primesWithPalindrome.size() = " + primesWithPalindrome.size());
        System.out.println(primesWithPalindrome.stream().map(String::valueOf).collect(joining(",")));
        long end = System.currentTimeMillis();
        System.out.println("end = " + end);
        System.out.println("time " + (end - start));
    }


    public static boolean isPalindrome(int n) {
        if (digit8Range.contains(n) || digit6Range.contains(n) || digit4Range.contains(n)) {
            return false;
        }
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
