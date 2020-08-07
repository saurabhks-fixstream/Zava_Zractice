package com.leetcode.javapractice;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int zero = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zero++] = nums[i];
            } else {
                count++;
            }
        }
        int i = nums.length - 1;
        while (count > 0) {
            nums[i] = 0;
            i--;
            count--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 0, 1};
        moveZeroes(nums);
        System.out.print("[");
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}
