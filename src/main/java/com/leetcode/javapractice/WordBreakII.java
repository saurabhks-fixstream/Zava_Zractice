package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        return wordBreakHelper(s, wordDict, new HashMap<String, List<String>>());
    }

    private static List<String> wordBreakHelper(
            String s, List<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> result = new ArrayList<String>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0) {
                    result.add(word);
                } else {
                    for (String sub : wordBreakHelper(next, wordDict, memo)) {
                        result.add(word + " " + sub);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }

    public static void main(String[] args) {

        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wordBreak("catsanddog", wordDict));
    }
}
