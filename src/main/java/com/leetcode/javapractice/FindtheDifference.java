package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class FindtheDifference {

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char ch = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), (map.get(s.charAt(i)) + 1));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i)) && map.get(t.charAt(i)) != 0) {
                map.put(t.charAt(i), (map.get(t.charAt(i)) - 1));
            } else {
                ch = t.charAt(i);
                break;
            }
        }
        return ch;
    }

    public static void main(String[] args) {

        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
