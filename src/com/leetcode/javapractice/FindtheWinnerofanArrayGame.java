package com.leetcode.javapractice;

public class FindtheWinnerofanArrayGame {

    public static int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > winner) {
                winner = arr[i];
                count = 0;
            }
            if (++count == k) {
                break;
            }
        }
        return winner;
    }

    public static void main(String[] args) {

        int[] arr = { 2, 1, 3, 5, 4, 6, 7 };
        System.out.println(getWinner(arr, 2));

    }

}
