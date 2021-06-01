package com.leetcode.javapractice;

import java.util.PriorityQueue;

public class MinimumCosttoConnectSticks {

    public static int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        int sum = 0;
        while (!pq.isEmpty() && pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            pq.add(temp);
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] sticks = {2, 4, 3};
        System.out.println(connectSticks(sticks));
    }
}
