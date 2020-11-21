package com.leetcode.javapractice;

public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] A, int K) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (sum < K) {
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] A = {34, 23, 1, 24, 75, 33, 54, 8};
        System.out.println(twoSumLessThanK(A, 60));
    }
}
