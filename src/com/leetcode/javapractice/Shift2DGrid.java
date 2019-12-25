package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int m = grid.length;
        int n = grid[0].length;
        k %= m * n;
        int[] array = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i * n + j] = grid[i][j];
            }
        }
        reverse(array, 0, m * n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, m * n - 1);
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                list.add(array[i * n + j]);
            }
            result.add(list);
        }
        return result;
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[][] grid = { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        System.out.println(shiftGrid(grid, 4));

    }

}
