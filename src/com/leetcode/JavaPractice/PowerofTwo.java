package com.leetcode.JavaPractice;

public class PowerofTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(1));

    }

}
