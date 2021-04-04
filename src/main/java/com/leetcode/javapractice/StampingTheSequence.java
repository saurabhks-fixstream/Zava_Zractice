package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class StampingTheSequence {

    public static int[] movesToStamp(String stamp, String target) {
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        List<Integer> res = new ArrayList<Integer>();
        boolean[] visited = new boolean[t.length];
        int stars = 0;
        while (stars < t.length) {
            boolean doneReplace = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!visited[i] && canReplace(t, i, s)) {
                    stars = doReplace(t, i, s.length, stars);
                    doneReplace = true;
                    visited[i] = true;
                    res.add(i);
                    if (stars == t.length) {
                        break;
                    }
                }
            }
            if (!doneReplace) {
                return new int[0];
            }
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(res.size() - i - 1);
        }
        return resArray;
    }

    private static boolean canReplace(char[] t, int p, char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (t[i + p] != '*' && t[i + p] != s[i]) {
                return false;
            }
        }
        return true;
    }

    private static int doReplace(char[] t, int p, int len, int count) {
        for (int i = 0; i < len; i++) {
            if (t[i + p] != '*') {
                t[i + p] = '*';
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] result = movesToStamp("abc", "ababc");
        for (int i : result) {
            System.out.print(i + ", ");
        }
    }
}
