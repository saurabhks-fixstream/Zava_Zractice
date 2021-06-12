package com.leetcode.javapractice;

public class MaxAreaofIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, maxAreaOfIslandHelper(grid, visited, m, n, i, j, 0));
                }
            }
        }
        return max;
    }

    private static int maxAreaOfIslandHelper(
            int[][] grid, boolean[][] visited, int m, int n, int i, int j, int count) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1
                + maxAreaOfIslandHelper(grid, visited, m, n, i - 1, j, count)
                + maxAreaOfIslandHelper(grid, visited, m, n, i, j - 1, count)
                + maxAreaOfIslandHelper(grid, visited, m, n, i + 1, j, count)
                + maxAreaOfIslandHelper(grid, visited, m, n, i, j + 1, count);
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}
