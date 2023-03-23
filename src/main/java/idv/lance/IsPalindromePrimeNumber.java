package idv.lance;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
public class IsPalindromePrimeNumber {

    public static void main(String[] args) {

        int a = 100, b = 100000000;


        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        int N = b;
        boolean[] isPrime = new boolean[N];
        isPrime[0] = isPrime[1] = true;
        int[] prime = new int[N];
        prime[0] = 2;
        int t = 0;
        for (int i = 2; i < N; i++) {

            if (!isPrime[i]) {
                prime[t++] = i;
            }

            for (int j = 0; j < t && prime[j] * i < N; j++) {
                int idx = i * prime[j];
                isPrime[idx] = true;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }

        List<Integer> primes = Arrays.stream(prime).filter(i -> i != 0).boxed().collect(toList());
        System.out.println("primes size " + primes.size());
        List<Integer> primesWithPalindrome = primes.stream().filter(IsPalindromePrimeNumber::isPalindrome)
                .filter(i -> i > a)
                .collect(toList());
        System.out.println("primesWithPalindrome.size() = " + primesWithPalindrome.size());
        System.out.println(primesWithPalindrome.stream().map(String::valueOf).collect(Collectors.joining(",")));
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
