package com.leetcode.javapractice;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGameVI {

    public static int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            int prevMax = deque.isEmpty() ? 0 : dp[deque.peekFirst()];
            dp[i] = nums[i] + prevMax;
            while (!deque.isEmpty() && dp[deque.peekLast()] < dp[i]) {
                deque.pollLast();
            }
            deque.add(i);
            while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {

        int[] nums = {1, -1, -2, 4, -7, 3};
        System.out.println(maxResult(nums, 2));
    }
}
