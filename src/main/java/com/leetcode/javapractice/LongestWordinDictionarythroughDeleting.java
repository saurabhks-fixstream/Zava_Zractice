package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {

    public static String findLongestWord(String s, List<String> d) {
        Collections.sort(
                d,
                (a, b) ->
                        a.length() != b.length() ? -Integer.compare(a.length(), b.length()) : a.compareTo(b));
        for (String dictWord : d) {
            int i = 0;
            for (char c : s.toCharArray())
                if (i < dictWord.length() && c == dictWord.charAt(i)) {
                    i++;
                }
            if (i == dictWord.length()) {
                return dictWord;
            }
        }
        return "";
    }

    public static void main(String[] args) {

        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord("abpcplea", d));
    }
}
