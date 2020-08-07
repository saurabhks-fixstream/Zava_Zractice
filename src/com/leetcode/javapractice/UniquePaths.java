package com.leetcode.javapractice;

import java.util.Arrays;

public class UniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dir = {{0, 1}, {1, 0}};
        int[][] memo = new int[m + 1][n + 1];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return uniquePathsHelper(m, n, 0, 0, dir, memo);
    }

    private static int uniquePathsHelper(int m, int n, int x, int y, int[][] dir, int[][] memo) {
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
            if (valid(m, n, x, y)) {
                result += uniquePathsHelper(m, n, x, y, dir, memo);
            }
            x -= dir[i][0];
            y -= dir[i][1];
        }
        memo[x][y] = result;
        return result;
    }

    private static boolean valid(int m, int n, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 2));

    }

}
