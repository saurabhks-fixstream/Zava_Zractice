package com.leetcode.javapractice;

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    count++;
                    s[j] = 0;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] g = { 1, 2, 3 };
        int[] s = { 1, 1 };
        System.out.println(findContentChildren(g, s));

    }

}
