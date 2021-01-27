package com.leetcode.javapractice;

import java.util.Stack;

public class FindtheMostCompetitiveSubsequence {

    public static int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty()
                    && (nums[i] < nums[stack.peek()])
                    && (nums.length - i + stack.size() > k)) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            result[i] = nums[stack.pop()];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 5, 2, 6};
        System.out.println(mostCompetitive(nums, 2));
    }
}
