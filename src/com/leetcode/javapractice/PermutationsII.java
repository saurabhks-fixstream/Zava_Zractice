package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteUniqueHelper(nums, 0, result);
        return result;
    }

    private static void permuteUniqueHelper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(getList(nums));
        }
        Set<Integer> appeared = new HashSet<Integer>();
        for (int i = index; i < nums.length; i++) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permuteUniqueHelper(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static List<Integer> getList(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));

    }

}
