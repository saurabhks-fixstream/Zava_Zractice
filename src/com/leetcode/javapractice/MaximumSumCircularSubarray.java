package com.leetcode.javapractice;

public class MaximumSumCircularSubarray {

    public static int maxSubarraySumCircular(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int curMax = 0;
        int curMin = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            curMax = curMax < 0 ? A[i]
                                : curMax + A[i];
            maxSum = Math.max(maxSum, curMax);
            curMin = curMin > 0 ? A[i]
                                : curMin + A[i];
            minSum = Math.min(minSum, curMin);
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum)
                          : maxSum;
    }

    public static void main(String[] args) {

        int[] A = { 1, -2, 3, -2 };
        System.out.println(maxSubarraySumCircular(A));

    }

}
