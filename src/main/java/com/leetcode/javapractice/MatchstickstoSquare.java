package com.leetcode.javapractice;

import java.util.Arrays;

public class MatchstickstoSquare {

    public static boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return makesquareHelper(matchsticks, new int[4], 0, sum / 4);
    }

    private static boolean makesquareHelper(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) {
                continue;
            }
            sums[i] += nums[index];
            if (makesquareHelper(nums, sums, index + 1, target)) {
                return true;
            }
            sums[i] -= nums[index];
        }
        return false;
    }

    private static void reverse(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        int[] matchsticks = {1, 1, 2, 2, 2};
        System.out.println(makesquare(matchsticks));
    }
}
