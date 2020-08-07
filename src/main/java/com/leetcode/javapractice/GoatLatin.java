package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    public static String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(goatify(words[i], i));
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String goatify(String S, int index) {
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<Character>();
        set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char first = S.charAt(0);
        if (set.contains(first)) {
            sb.append(S);
            sb.append("ma");
        } else {
            if (S.length() > 1) {
                sb.append(S.substring(1));
            }
            sb.append(first);
            sb.append("ma");
        }
        while (index >= 0) {
            sb.append("a");
            index--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(toGoatLatin("I speak Goat Latin"));
    }
}
