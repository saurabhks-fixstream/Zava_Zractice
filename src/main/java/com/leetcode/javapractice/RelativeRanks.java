package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {

    public static String[] findRelativeRanks(int[] nums) {
        String[] ranks = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                ranks[map.get(nums[i])] = "Gold Medal";
            } else if (i == nums.length - 2) {
                ranks[map.get(nums[i])] = "Silver Medal";
            } else if (i == nums.length - 3) {
                ranks[map.get(nums[i])] = "Bronze Medal";
            } else {
                ranks[map.get(nums[i])] = String.valueOf(nums.length - i);
            }
        }
        return ranks;
    }

    public static void main(String[] args) {

        int[] nums = {10, 3, 8, 9, 4};
        String[] ranks = findRelativeRanks(nums);
        for (String s : ranks) {
            System.out.print(s + " ");
        }
    }
}
