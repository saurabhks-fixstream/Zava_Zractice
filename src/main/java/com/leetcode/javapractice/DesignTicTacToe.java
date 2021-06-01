package com.leetcode.javapractice;

class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        if (row == col) {
            diagonal += currentPlayer;
        }
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        if (Math.abs(rows[row]) == n
                || Math.abs(cols[col]) == n
                || Math.abs(diagonal) == n
                || Math.abs(antiDiagonal) == n) {
            return player;
        }
        return 0;
    }
}

public class DesignTicTacToe {

    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println(ticTacToe.move(0, 0, 1));
        System.out.println(ticTacToe.move(0, 2, 2));
        System.out.println(ticTacToe.move(2, 2, 1));
        System.out.println(ticTacToe.move(1, 1, 2));
        System.out.println(ticTacToe.move(2, 0, 1));
        System.out.println(ticTacToe.move(1, 0, 2));
        System.out.println(ticTacToe.move(2, 1, 1));
    }
}
