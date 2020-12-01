package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> index = new HashMap<Character, Integer>();
        int low = 0;
        int high = 0;
        int result = 0;
        while (high < s.length()) {
            if (index.size() <= 2) {
                char c = s.charAt(high);
                index.put(c, high);
                high++;
            }
            if (index.size() > 2) {
                int leftMost = s.length();
                for (int i : index.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                low = leftMost + 1;
            }
            result = Math.max(result, high - low);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
