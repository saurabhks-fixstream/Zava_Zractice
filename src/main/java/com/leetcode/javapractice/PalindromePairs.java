package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PalindromePairs {

    public static List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordSet = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            wordSet.put(words[i], i);
        }
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        for (Entry<String, Integer> word : wordSet.entrySet()) {
            int currentWordIndex = wordSet.get(word.getKey());
            String reversedWord = new StringBuilder(word.getKey()).reverse().toString();
            if (wordSet.containsKey(reversedWord) && wordSet.get(reversedWord) != currentWordIndex) {
                solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedWord)));
            }
            for (String suffix : allValidSuffixes(word.getKey())) {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (wordSet.containsKey(reversedSuffix)) {
                    solution.add(Arrays.asList(wordSet.get(reversedSuffix), currentWordIndex));
                }
            }
            for (String prefix : allValidPrefixes(word.getKey())) {
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (wordSet.containsKey(reversedPrefix)) {
                    solution.add(Arrays.asList(currentWordIndex, wordSet.get(reversedPrefix)));
                }
            }
        }
        return solution;
    }

    private static List<String> allValidPrefixes(String word) {
        List<String> validPrefixes = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, i, word.length() - 1)) {
                validPrefixes.add(word.substring(0, i));
            }
        }
        return validPrefixes;
    }

    private static List<String> allValidSuffixes(String word) {
        List<String> validSuffixes = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            if (isPalindromeBetween(word, 0, i)) {
                validSuffixes.add(word.substring(i + 1, word.length()));
            }
        }
        return validSuffixes;
    }

    private static boolean isPalindromeBetween(String word, int front, int back) {
        while (front < back) {
            if (word.charAt(front) != word.charAt(back)) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    public static void main(String[] args) {

        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(palindromePairs(words));
    }
}
