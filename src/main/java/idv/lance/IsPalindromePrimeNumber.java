package idv.lance;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public class IsPalindromePrimeNumber {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int N = 1000000000;
    boolean[] isPrime = new boolean[N + 1];
    isPrime[0] = isPrime[1] = true;

    int[] Prime = new int[N];
    int t = 0;
    for (int i = 2; i < N; i++) {
      if (!isPrime[i]) {
        Prime[t++] = i;
      }

      for (int j = 0; j < t && Prime[j] * i < N; j++) {
        isPrime[i * Prime[j]] = true;
        if (i % Prime[j] == 0) break;
      }
    }

    List<Integer> primes = Arrays.stream(Prime).filter(i -> i != 0).boxed().collect(toList());
    System.out.println("primes size " + primes.size());

    List<Integer> primesWithPalindrome =
        primes.stream().filter(IsPalindromePrimeNumber::isPalindrome).collect(toList());

    System.out.println("primesWithPalindrome.size() = " + primesWithPalindrome.size());

    System.out.println(primesWithPalindrome.stream().map(String::valueOf).collect(joining(",")));
    long end = System.currentTimeMillis();
    System.out.println("time " + (end - start));
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
