package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        int wordsLen = words.length;
        int i = 0;
        int j = wordLen * wordsLen;
        while (i <= s.length() - j) {
            if (isConcat(s.substring(i, i + j), new HashMap<String, Integer>(wordMap), wordLen)) {
                result.add(i);
            }
            i++;
        }
        return result;
    }

    private static boolean isConcat(String s, Map<String, Integer> wordMap, int len) {
        if (s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0; i <= (s.length() - len); i += len) {
            String word = s.substring(i, i + len);
            if (wordMap.containsKey(word) && wordMap.get(word) > 0) {
                wordMap.put(word, wordMap.get(word) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String[] words = {"foo", "bar"};
        System.out.println(findSubstring("barfoothefoobarman", words));
    }
}
