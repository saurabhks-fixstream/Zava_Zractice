package com.leetcode.JavaPractice;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int jump = 0;
        for (int i = 0; i <= jump; i++) {
            jump = Math.max(jump, i + nums[i]);
            if (jump >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 5, 0, 0 };
        System.out.println(canJump(nums));

    }

}
