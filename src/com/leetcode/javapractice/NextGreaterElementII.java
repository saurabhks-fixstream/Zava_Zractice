package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                result[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1 };
        int[] result = nextGreaterElements(nums);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }

}
