package com.leetcode.javapractice;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1
                    : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 3, 3, 4, 4, 3, 2, 2, 2, 4, 5, 5};
        System.out.println(majorityElement(nums));

    }

}
