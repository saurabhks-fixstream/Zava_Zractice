package com.leetcode.javapractice;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int currYes = 0;
        int currNo = 0;
        for (int i = 0; i < nums.length; i++) {
            int prevNo = currNo;
            currNo = Math.max(prevNo, currYes);
            currYes = prevNo + nums[i];
        }
        return Math.max(currNo, currYes);
    }

    public static void main(String[] args) {

        int[] nums = { 3, 2, 4, 2, 6, 55, 3, 22, 11, 4, 66, 3, };
        System.out.println(rob(nums));

    }

}
