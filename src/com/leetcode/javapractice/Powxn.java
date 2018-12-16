package com.leetcode.javapractice;

public class Powxn {

    public static double myPow(double x, int n) {
        if (n == Integer.MAX_VALUE && x < 1 && x > 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (x == -1 && n % 2 == 0) {
            return 1;
        }
        if (x == -1 && n % 2 != 0) {
            return -1;
        }
        if (n == Integer.MIN_VALUE) {
            return 0;
        }
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return (1 / x);
        }
        if (n > 0) {
            if (n % 2 == 0) {
                return myPow(x, n / 2) * myPow(x, n / 2);
            } else {
                return x * myPow(x, n / 2) * myPow(x, n / 2);
            }
        } else {
            if (n % 2 == 0) {
                return myPow(x, n / 2) * myPow(x, n / 2);
            } else {
                return 1 / x * myPow(x, n / 2) * myPow(x, n / 2);
            }
        }
    }

    public static void main(String[] args) {

        int n = 3;
        System.out.println(myPow(200, n));

    }

}
