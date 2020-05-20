package com.leetcode.javapractice;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = dailyTemperatures(T);
        for (int r : result) {
            System.out.print(r + " ");
        }

    }

}
