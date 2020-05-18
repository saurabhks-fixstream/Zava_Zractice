package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Set<String> words = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || dp[j - 1]) {
                    if (words.contains(s.substring(j, i + 1))) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {

        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak("leetcode", wordDict));

    }

}
