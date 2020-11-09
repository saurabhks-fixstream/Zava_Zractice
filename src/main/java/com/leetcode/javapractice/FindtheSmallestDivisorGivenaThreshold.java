package com.leetcode.javapractice;

public class FindtheSmallestDivisorGivenaThreshold {

    public static int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MAX_VALUE;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = getSum(nums, mid);
            if (sum <= threshold) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }
}
