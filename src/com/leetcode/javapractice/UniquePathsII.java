package com.leetcode.javapractice;

import java.util.Arrays;

public class UniquePathsII {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dir = { { 0, 1 }, { 1, 0 } };
        int[][] memo = new int[m + 1][n + 1];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return uniquePathsWithObstaclesHelper(obstacleGrid, m, n, 0, 0, dir, memo);

    }

    private static int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int m, int n, int x, int y, int[][] dir,
                                                      int[][] memo) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        int result = 0;
        for (int i = 0; i < dir.length; i++) {
            x += dir[i][0];
            y += dir[i][1];
            if (valid(obstacleGrid, m, n, x, y)) {
                result += uniquePathsWithObstaclesHelper(obstacleGrid, m, n, x, y, dir, memo);
            }
            x -= dir[i][0];
            y -= dir[i][1];
        }
        memo[x][y] = result;
        return result;
    }

    private static boolean valid(int[][] obstacleGrid, int m, int n, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || obstacleGrid[x][y] == 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }

}
