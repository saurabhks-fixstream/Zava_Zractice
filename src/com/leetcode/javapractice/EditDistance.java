package com.leetcode.javapractice;

import java.util.Arrays;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return minDistanceHelper(word1, word2, m, n, memo);
    }

    private static int minDistanceHelper(String word1, String word2, int m, int n, int[][] memo) {
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            memo[m][n] = minDistanceHelper(word1, word2, m - 1, n - 1, memo);
            return memo[m][n];
        }
        memo[m][n] = 1 + Math.min(minDistanceHelper(word1, word2, m, n - 1, memo),
                Math.min(minDistanceHelper(word1, word2, m - 1, n, memo),
                        minDistanceHelper(word1, word2, m - 1, n - 1, memo)));
        return memo[m][n];

    }

    public static void main(String[] args) {

        System.out.println(minDistance("horse", "ros"));

    }

}
