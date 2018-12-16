package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), (map.get(s.charAt(i)) + 1));
            }
        }
        int odd = 0;
        for (int i : map.values()) {
            if (i % 2 != 0) {
                odd++;
            }
            length += i;
        }
        if (odd <= 1) {
            return length;
        } else {
            return length - odd + 1;
        }
    }

    public static void main(String[] args) {

        String s = "abccccdd";
        System.out.println(longestPalindrome(s));

    }

}
