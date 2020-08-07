package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permuteHelper(nums, 0, result);
        return result;
    }

    private static void permuteHelper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(getList(nums));
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permuteHelper(nums, index + 1, result);
            swap(nums, index, i);
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

        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
