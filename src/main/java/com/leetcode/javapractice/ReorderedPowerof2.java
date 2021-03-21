package com.leetcode.javapractice;

public class ReorderedPowerof2 {

    public static boolean reorderedPowerOf2(int N) {
        long c = counter(N);
        for (int i = 0; i < 32; i++) {
            if (counter(1 << i) == c) {
                return true;
            }
        }
        return false;
    }

    private static long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) {
            res += (int) Math.pow(10, N % 10);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(reorderedPowerOf2(1));
    }
}
