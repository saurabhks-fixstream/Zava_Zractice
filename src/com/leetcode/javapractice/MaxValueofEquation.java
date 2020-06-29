package com.leetcode.javapractice;

import java.util.PriorityQueue;

public class MaxValueofEquation {

    public static int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1] - b[0], a[1] - a[0]));
        for (int[] point : points) {
            while (!pq.isEmpty() && point[0] - pq.peek()[0] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                int[] head = pq.peek();
                max = Math.max(max, point[0] + point[1] + head[1] - head[0]);
            }
            pq.offer(point);
        }
        return max;
    }

    public static void main(String[] args) {

        int[][] points = { { 1, 3 }, { 2, 0 }, { 5, 10 }, { 6, -10 } };
        System.out.println(findMaxValueOfEquation(points, 1));

    }

}
