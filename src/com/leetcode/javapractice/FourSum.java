package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k) {
            return result;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums[i]));
                    list.addAll(set);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum == target) {
                result.add(Arrays.asList(nums[lo], nums[hi]));
                while (lo < hi && nums[lo] == nums[lo + 1]) {
                    lo++;
                }
                while (lo < hi && nums[hi] == nums[hi - 1]) {
                    hi--;
                }
                lo++;
                hi--;
            } else if (sum < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));

    }

}
