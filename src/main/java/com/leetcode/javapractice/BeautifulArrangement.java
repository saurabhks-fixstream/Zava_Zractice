package com.leetcode.javapractice;

public class BeautifulArrangement {

    static int count = 0;

    public static int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        countArrangementHelper(n, 1, visited);
        return count;
    }

    public static void countArrangementHelper(int n, int pos, boolean[] visited) {
        if (pos > n) {
            count++;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                countArrangementHelper(n, pos + 1, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(countArrangement(2));
    }
}
