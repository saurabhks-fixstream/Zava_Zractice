package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            end++;
            while (map.size() > k) {
                c = s.charAt(start);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        map.remove(c);
                    }
                }
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
