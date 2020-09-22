package com.leetcode.javapractice;

public class UniquePathsIII {

    static int empty = 1;
    static int result = 0;

    public static int uniquePathsIII(int[][] grid) {
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        uniquePathsIIIHelper(grid, sx, sy);
        return result;
    }

    public static void uniquePathsIIIHelper(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] < 0) {
            return;
        }
        if (grid[x][y] == 2) {
            if (empty == 0) {
                result++;
            }
            return;
        }
        grid[x][y] = -2;
        empty--;
        uniquePathsIIIHelper(grid, x + 1, y);
        uniquePathsIIIHelper(grid, x - 1, y);
        uniquePathsIIIHelper(grid, x, y + 1);
        uniquePathsIIIHelper(grid, x, y - 1);
        grid[x][y] = 0;
        empty++;
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(uniquePathsIII(grid));
    }
}
