package com.leetcode.javapractice;

public class OnesandZeroes {

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int countZero = 0;
            int countOne = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
            }
            for (int i = m; i >= countZero; i--) {
                for (int j = n; j >= countOne; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - countZero][j - countOne] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }
}
