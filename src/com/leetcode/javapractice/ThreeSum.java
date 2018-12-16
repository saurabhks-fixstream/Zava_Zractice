package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return list;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int target = -nums[i];
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    list.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high + 1]) {
                        high--;
                    }
                } else if (nums[low] + nums[high] > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> l : list) {
            System.out.println(l);
        }

    }

}
