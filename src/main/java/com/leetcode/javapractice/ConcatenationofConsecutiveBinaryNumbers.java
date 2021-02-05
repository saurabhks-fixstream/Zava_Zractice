package com.leetcode.javapractice;

public class ConcatenationofConsecutiveBinaryNumbers {

    public static int concatenatedBinary(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            sum = ((sum << binary.length()) + i) % 1000000007;
        }
        return (int) sum;
    }

    public static void main(String[] args) {

        System.out.println(concatenatedBinary(12));
    }
}
