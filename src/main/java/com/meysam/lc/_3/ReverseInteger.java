package com.meysam.lc._3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseInteger {


    @Test
    void testPositive() {
        int a = 123;
        Assertions.assertEquals(321, reverse(a));
    }

    @Test
    void testNegative() {
        int a = -123;
        Assertions.assertEquals(-321, reverse(a));
    }

    @Test
    void testWithEndingZero() {
        int a = 120;
        Assertions.assertEquals(21, reverse(a));
    }

    @Test
    void testBigNum() {
        int a = 1534236469;
        Assertions.assertEquals(0, reverse(a));
    }


    public int reverse(int x) {

        long i = 0;
        long n = Math.abs(x);
        while (n > 0) {
            i += (n % 10);
            i *= 10;
            n = n / 10;
        }
        i = i / 10;
        if (x < 0)
            i *= -1;

        // check overflow
        if (i > Integer.MAX_VALUE || i < Integer.MIN_VALUE)
            return 0;

        return (int) i;
    }
}
