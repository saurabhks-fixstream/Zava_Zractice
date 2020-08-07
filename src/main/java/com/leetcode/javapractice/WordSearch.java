package com.leetcode.javapractice;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(word, board, 0, i, j, board.length, board[0].length)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(String word, char[][] board, int idx, int i, int j, int x, int y) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= x || j < 0 || j >= y || board[i][j] != word.charAt(idx)) {
            return false;
        }
        board[i][j] = '*';
        boolean result =
                dfs(word, board, idx + 1, i - 1, j, x, y)
                        || dfs(word, board, idx + 1, i + 1, j, x, y)
                        || dfs(word, board, idx + 1, i, j + 1, x, y)
                        || dfs(word, board, idx + 1, i, j - 1, x, y);
        board[i][j] = word.charAt(idx);
        return result;
    }

    public static void main(String[] args) {

        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCCED"));
    }
}
