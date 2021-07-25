package com.leetcode.javapractice;

public class PartitionArrayintoDisjointIntervals {

    public static int partitionDisjoint(int[] nums) {
        int localMax = nums[0];
        int partitionIdx = 0;
        int max = localMax;
        for (int i = 1; i < nums.length; i++)
            if (localMax > nums[i]) {
                localMax = max;
                partitionIdx = i;
            } else {
                max = Math.max(max, nums[i]);
            }
        return partitionIdx + 1;
    }

    public static void main(String[] args) {

        int[] nums = {5, 0, 3, 8, 6};
        System.out.println(partitionDisjoint(nums));
    }
}
