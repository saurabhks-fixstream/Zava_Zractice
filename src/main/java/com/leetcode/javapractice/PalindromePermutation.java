package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PalindromePermutation {

    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                odd++;
                if (odd > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(canPermutePalindrome("code"));
    }
}
