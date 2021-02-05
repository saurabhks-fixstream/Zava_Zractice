package com.leetcode.javapractice;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimizeDeviationinArray {

    public static int minimumDeviation(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<Integer>();
        int mi = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a % 2 == 1) {
                a *= 2;
            }
            pq.add(-a);
            mi = Math.min(mi, a);
        }
        while (true) {
            int a = -pq.poll();
            res = Math.min(res, a - mi);
            if (a % 2 == 1) {
                break;
            }
            mi = Math.min(mi, a / 2);
            pq.add(-a / 2);
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(minimumDeviation(nums));
    }
}
