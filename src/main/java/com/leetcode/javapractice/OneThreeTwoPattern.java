package com.leetcode.javapractice;

import java.util.Stack;

public class OneThreeTwoPattern {

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                min = num;
            } else {
                while (!stack.empty()) {
                    if (stack.peek() >= num) {
                        break;
                    }
                    stack.pop();
                    if (stack.pop() > num) {
                        return true;
                    }
                }
                stack.push(num);
                stack.push(min);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(find132pattern(nums));
    }
}
