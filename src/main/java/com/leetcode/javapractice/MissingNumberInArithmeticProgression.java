package com.leetcode.javapractice;

public class MissingNumberInArithmeticProgression {

    public static int missingNumber(int[] arr) {
        int first = arr[0];
        int last = arr[0];
        int sum = 0;
        int n = arr.length;
        for (int a : arr) {
            first = Math.min(first, a);
            last = Math.max(last, a);
            sum += a;
        }
        return (first + last) * (n + 1) / 2 - sum;
    }

    public static void main(String[] args) {

        int[] arr = {5, 7, 11, 13};
        System.out.println(missingNumber(arr));
    }
}
