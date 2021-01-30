package com.leetcode.javapractice;

public class NumberOfCornerRectangles {

    public static int countCornerRectangles(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int counter = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    ans += counter * (counter - 1) / 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};
        System.out.println(countCornerRectangles(grid));
    }
}
