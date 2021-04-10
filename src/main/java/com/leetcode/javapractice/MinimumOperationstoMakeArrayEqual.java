package com.leetcode.javapractice;

public class MinimumOperationstoMakeArrayEqual {

    public static int minOperations(int n) {
        if (n % 2 == 1) {
            n /= 2;
            return (n * (n + 1));
        }
        n /= 2;
        return n * n;
    }

    public static void main(String[] args) {

        System.out.println(minOperations(3));
    }
}
