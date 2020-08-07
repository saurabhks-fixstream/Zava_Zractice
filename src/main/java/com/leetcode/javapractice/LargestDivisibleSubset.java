package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        int max = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && (1 + dp[j]) > dp[i]) {
                    dp[i] = 1 + dp[j];
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }
        while (index != -1) {
            result.add(nums[index]);
            index = prev[index];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(largestDivisibleSubset(nums));
    }
}
