package com.leetcode.javapractice;

public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        double max = 0;
        double sum = 0;
        int i = 0;
        while (k-- > 0) {
            sum += nums[i++];
        }
        k = i;
        max = sum / k;
        for (int j = i; j < nums.length; j++) {
            sum = sum - nums[j - k] + nums[j];
            double avg = (sum / k);
            if (max <= avg) {
                max = avg;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }
}
