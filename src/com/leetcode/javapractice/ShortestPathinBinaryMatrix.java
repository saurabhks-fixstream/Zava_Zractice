package com.leetcode.javapractice;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] g = queue.poll();
                if (g[0] == n - 1 && g[1] == n - 1) {
                    return count;
                }
                for (int j = 0; j < dirs.length; j++) {
                    int x = g[0] + dirs[j][0];
                    int y = g[1] + dirs[j][1];
                    if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || grid[x][y] == 1) {
                        continue;
                    }
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));

    }

}
