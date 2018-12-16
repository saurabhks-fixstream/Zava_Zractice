package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1 };
        int k = 0;
        System.out.println(containsNearbyDuplicate(nums, k));

    }

}
