package com.leetcode.javapractice;

public class MaximumLengthofRepeatedSubarray {

    public static int findLength(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return 0;
        }
        int m = nums1.length;
        int n = nums2.length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));
    }
}
