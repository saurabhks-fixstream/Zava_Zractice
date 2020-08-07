package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinanArray {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] < 0) {
                result.add(Math.abs(nums[i]));
            }
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }
}
