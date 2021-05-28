package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.Stack;

public class FindtheShortestSuperstring {

    public static String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(words[i], words[j]);
                graph[j][i] = calc(words[j], words[i]);
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int last = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = words[j].length();
                    } else {
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if (i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = (1 << n) - 1;
        Stack<Integer> stack = new Stack<Integer>();
        while (cur > 0) {
            stack.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }
        int i = stack.pop();
        sb.append(words[i]);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            sb.append(words[j].substring(words[j].length() - graph[i][j]));
            i = j;
        }
        return sb.toString();
    }

    private static int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }

    public static void main(String[] args) {

        String[] words = {"alex", "loves", "leetcode"};
        System.out.println(shortestSuperstring(words));
    }
}
