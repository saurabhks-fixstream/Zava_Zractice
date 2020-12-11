package com.leetcode.javapractice;

public class MaximumAverageSubarrayII {

    public static double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return Integer.MIN_VALUE;
        }
        double min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        while (min <= max) {
            double mid = min + (max - min) / 2.0;
            if (hasAvgAbove(nums, k, mid)) {
                min = mid + 0.000_005;
            } else {
                max = mid - 0.000_005;
            }
        }
        return max;
    }

    private static boolean hasAvgAbove(int[] nums, int k, double target) {
        double sum = 0, extraSum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - target;
        }
        int curr = k;
        while (curr < nums.length) {
            if (sum >= 0) return true;
            sum += nums[curr] - target;
            extraSum += nums[curr - k] - target;
            if (extraSum < 0) {
                sum -= extraSum;
                extraSum = 0;
            }
            curr++;
        }
        return sum >= 0;
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
