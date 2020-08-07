package com.leetcode.javapractice;

public class FindNumberswithEvenNumberofDigits {

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digit = 0;
            while (num > 0) {
                digit++;
                num /= 10;
            }
            if (digit % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums));

    }

}
