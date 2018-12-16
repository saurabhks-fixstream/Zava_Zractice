package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        int count = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsKey(s.charAt(i))) {
                count++;
                longest = (longest > count ? longest
                                           : count);
                hm.put(s.charAt(i), i);
            } else {
                int k = hm.get(s.charAt(i));
                while (hm.containsValue(k)) {
                    hm.remove(s.charAt(k));
                    k--;
                    count--;
                }
                hm.put(s.charAt(i), i);
                count++;
            }
        }
        return longest;
    }

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("dvdf"));

    }

}
