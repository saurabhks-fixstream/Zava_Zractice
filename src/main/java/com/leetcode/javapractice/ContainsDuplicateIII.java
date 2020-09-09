package com.leetcode.javapractice;

import java.util.TreeSet;

public class ContainsDuplicateIII {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) {
                return true;
            }
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
