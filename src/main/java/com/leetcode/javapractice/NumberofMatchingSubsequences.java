package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class NumberofMatchingSubsequences {

    public static int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        List<StringBuilder>[] waiting = new ArrayList[128];
        for (int c = 0; c <= 'z'; c++) {
            waiting[c] = new ArrayList<StringBuilder>();
        }
        for (String w : words) {
            waiting[w.charAt(0)].add(new StringBuilder(w));
        }
        for (char c : s.toCharArray()) {
            List<StringBuilder> advance = waiting[c];
            waiting[c] = new ArrayList<StringBuilder>();
            for (StringBuilder it : advance) {
                it.deleteCharAt(0);
                if (it.length() != 0) {
                    waiting[it.charAt(0)].add(it);
                } else {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq("abcde", words));
    }
}
