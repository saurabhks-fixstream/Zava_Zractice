package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordSquares {

    static int N;
    static String[] wordList;
    static HashMap<String, List<String>> prefixHashTable;

    public static List<List<String>> wordSquares(String[] words) {
        wordList = words;
        N = words[0].length();
        List<List<String>> results = new ArrayList<List<String>>();
        buildPrefixHashTable(words);
        for (String word : words) {
            LinkedList<String> wordSquares = new LinkedList<String>();
            wordSquares.addLast(word);
            backtracking(1, wordSquares, results);
        }
        return results;
    }

    private static void backtracking(
            int step, LinkedList<String> wordSquares, List<List<String>> results) {
        if (step == N) {
            results.add((new ArrayList<String>(wordSquares)));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String word : wordSquares) {
            prefix.append(word.charAt(step));
        }
        for (String candidate : getWordsWithPrefix(prefix.toString())) {
            wordSquares.addLast(candidate);
            backtracking(step + 1, wordSquares, results);
            wordSquares.removeLast();
        }
    }

    private static void buildPrefixHashTable(String[] words) {
        prefixHashTable = new HashMap<String, List<String>>();
        for (String word : words) {
            for (int i = 1; i < N; i++) {
                String prefix = word.substring(0, i);
                List<String> wordList = prefixHashTable.get(prefix);
                if (wordList == null) {
                    wordList = new ArrayList<String>();
                    wordList.add(word);
                    prefixHashTable.put(prefix, wordList);
                } else {
                    wordList.add(word);
                }
            }
        }
    }

    private static List<String> getWordsWithPrefix(String prefix) {
        List<String> wordList = prefixHashTable.get(prefix);
        return (wordList != null ? wordList : new ArrayList<String>());
    }

    public static void main(String[] args) {

        String[] words = {"area", "lead", "wall", "lady", "ball"};
        System.out.println(wordSquares(words));
    }
}
