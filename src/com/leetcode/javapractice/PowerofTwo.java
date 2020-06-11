package com.leetcode.javapractice;

public class PowerofTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1 ? true
                      : false;
    }

    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(1));

    }

}
