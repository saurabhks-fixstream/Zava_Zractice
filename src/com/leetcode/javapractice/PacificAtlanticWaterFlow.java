package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pacificAtlanticHelper(matrix, pacific, i, 0, dir);
            pacificAtlanticHelper(matrix, atlantic, i, n - 1, dir);
        }
        for (int i = 0; i < n; i++) {
            pacificAtlanticHelper(matrix, pacific, 0, i, dir);
            pacificAtlanticHelper(matrix, atlantic, m - 1, i, dir);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private static void pacificAtlanticHelper(int[][] matrix, boolean[][] visited, int x, int y, int[][] dir) {
        int m = matrix.length;
        int n = matrix[0].length;
        visited[x][y] = true;
        for (int k = 0; k < dir.length; k++) {
            int i = x + dir[k][0];
            int j = y + dir[k][1];
            if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || matrix[x][y] > matrix[i][j]) {
                continue;
            }
            pacificAtlanticHelper(matrix, visited, i, j, dir);
        }
    }

    public static void main(String[] args) {

        int[][] matrix =
                {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(matrix));

    }

}
