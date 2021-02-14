package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands {

    public static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    numDistinctIslandsHelper(grid, i, j, sb, "o");
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private static void numDistinctIslandsHelper(
            int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == 0) {
            return;
        }
        sb.append(dir);
        grid[i][j] = 0;
        numDistinctIslandsHelper(grid, i - 1, j, sb, "u");
        numDistinctIslandsHelper(grid, i + 1, j, sb, "d");
        numDistinctIslandsHelper(grid, i, j - 1, sb, "l");
        numDistinctIslandsHelper(grid, i, j + 1, sb, "r");
        sb.append("b");
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(numDistinctIslands(grid));
    }
}
