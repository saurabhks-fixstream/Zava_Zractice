package com.leetcode.javapractice;

public class FibonacciNumber {

    public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int[] fibarray = new int[N + 1];
        fibarray[0] = 0;
        fibarray[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibarray[i] = fibarray[i - 1] + fibarray[i - 2];
        }
        return fibarray[N];
    }

    public static void main(String[] args) {

        System.out.println(fib(30));
    }
}
