package com.leetcode.javapractice;

public class SurroundedRegions {

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, m, n);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X' || board[i][j] == '*') {
            return;
        }
        board[i][j] = '*';
        dfs(board, i + 1, j, m, n);
        dfs(board, i, j + 1, m, n);
        dfs(board, i - 1, j, m, n);
        dfs(board, i, j - 1, m, n);
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] b : board) {
            for (char c : b) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
