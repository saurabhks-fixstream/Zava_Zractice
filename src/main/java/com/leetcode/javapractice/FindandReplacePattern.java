package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindandReplacePattern {

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = findAndReplacePatternHelper(pattern);
        List<String> res = new ArrayList<String>();
        for (String w : words) {
            if (Arrays.equals(findAndReplacePatternHelper(w), p)) {
                res.add(w);
            }
        }
        return res;
    }

    private static int[] findAndReplacePatternHelper(String w) {
        Map<Character, Integer> m = new HashMap<>();
        int n = w.length();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            m.putIfAbsent(w.charAt(i), m.size());
            res[i] = m.get(w.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {

        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        System.out.println(findAndReplacePattern(words, "abb"));
    }
}
