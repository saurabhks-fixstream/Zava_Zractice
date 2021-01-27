package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    static int[] DIR = new int[] {0, 1, 0, -1, 0};

    public static int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] {0, 0, 0});
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0];
            int r = top[1];
            int c = top[2];
            if (d > dist[r][c]) {
                continue;
            }
            if (r == m - 1 && c == n - 1) {
                return d;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + DIR[i];
                int nc = c + DIR[i + 1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newDist = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (dist[nr][nc] > newDist) {
                        dist[nr][nc] = newDist;
                        minHeap.offer(new int[] {dist[nr][nc], nr, nc});
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath(heights));
    }
}
