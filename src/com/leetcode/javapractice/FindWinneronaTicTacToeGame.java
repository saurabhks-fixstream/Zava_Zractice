package com.leetcode.javapractice;

public class FindWinneronaTicTacToeGame {

    public static String tictactoe(int[][] moves) {
        if (moves.length < 5) {
            return "Pending";
        }
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                board[moves[i][0]][moves[i][1]] = 'A';
            } else {
                board[moves[i][0]][moves[i][1]] = 'B';
            }
        }
        char winner = checkWinner(board);
        if (winner != 'D') {
            return Character.toString(winner);
        } else if (moves.length < 9) {
            return "Pending";
        } else {
            return "Draw";
        }
    }

    private static char checkWinner(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return 'D';
    }

    public static void main(String[] args) {

        int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        System.out.println(tictactoe(moves));

    }

}
