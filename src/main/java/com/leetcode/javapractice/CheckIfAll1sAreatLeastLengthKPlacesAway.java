package com.leetcode.javapractice;

public class CheckIfAll1sAreatLeastLengthKPlacesAway {

    public static boolean kLengthApart(int[] nums, int k) {
        int lastOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (lastOne != -1 && nums[i] == 1 && ((i - lastOne) <= k)) {
                return false;
            }
            if (nums[i] == 1) {
                lastOne = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, 0, 0, 1, 0, 0, 1};
        System.out.println(kLengthApart(nums, 2));
    }
}
