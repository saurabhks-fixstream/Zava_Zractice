package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringMatchinginanArray {

    public static List<String> stringMatching(String[] words) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSubstring(words[i], words[j])) {
                    result.add(words[i]);
                }
                if (isSubstring(words[j], words[i])) {
                    result.add(words[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }

    private static boolean isSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (s2.charAt(i + j) != s1.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] words = { "mass", "as", "hero", "superhero" };
        System.out.println(stringMatching(words));

    }

}
