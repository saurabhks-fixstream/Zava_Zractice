package com.leetcode.JavaPractice;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] arr = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        for (int i = 0; i <= n; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }

    public static void main(String[] args) {

        System.out.println(climbStairs(10));

    }

}
