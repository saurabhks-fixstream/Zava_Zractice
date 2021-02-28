package com.leetcode.javapractice;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return (1 << 31) - 1;
        }
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int result = 0;
        for (int x = 31; x >= 0; x--) {
            if ((a >>> x) - b >= 0) {
                result += 1 << x;
                a -= b << x;
            }
        }
        return (dividend > 0) == (divisor > 0) ? result : -result;
    }

    public static void main(String[] args) {

        System.out.println(divide(10, 3));
    }
}
