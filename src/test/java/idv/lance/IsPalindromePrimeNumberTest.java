package idv.lance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromePrimeNumberTest {

    @Test
    void test() {
        int digitsNumber = IsPalindromePrimeNumber.getDigitsNumber(100);
        assertEquals(digitsNumber, 3);
    }
}