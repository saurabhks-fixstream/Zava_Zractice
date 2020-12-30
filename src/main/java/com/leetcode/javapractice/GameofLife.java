package com.leetcode.javapractice;

import java.util.Arrays;

public class GameofLife {

    public static void gameOfLife(int[][] board) {
        int[][] temp = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = count(board, i, j, m, n);
                if (board[i][j] == 1) {
                    if (count < 2) {
                        temp[i][j] = 0;
                    }
                    if (count > 3) {
                        temp[i][j] = 0;
                    }
                } else if (count == 3) {
                    temp[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    private static int count(int[][] board, int i, int j, int m, int n) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (valid(x, y, m, n) && board[x][y] == 1) {
                count++;
            }
        }
        return count;
    }

    private static boolean valid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

    public static void main(String[] args) {

        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
