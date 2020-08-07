package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        subsetsHelper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void subsetsHelper(int[] nums, int index, List<Integer> list, List<List<Integer>> result) {
        if (index <= nums.length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsHelper(nums, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));

    }

}
