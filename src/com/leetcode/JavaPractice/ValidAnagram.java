package com.leetcode.JavaPractice;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        boolean anagram = true;
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        if (s.length() != t.length()) {
            anagram = false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                char charAsKey = s.charAt(i);
                int charCountAsValue = 0;
                if (smap.containsKey(charAsKey)) {
                    charCountAsValue = smap.get(charAsKey);
                }
                smap.put(charAsKey, ++charCountAsValue);
                charAsKey = t.charAt(i);
                charCountAsValue = 0;
                if (smap.containsKey(charAsKey)) {
                    charCountAsValue = smap.get(charAsKey);
                }
                smap.put(charAsKey, --charCountAsValue);
            }
        }
        for (int value : smap.values()) {
            if (value != 0) {
                anagram = false;
            }
        }
        return anagram;
    }

    public static void main(String[] args) {

        System.out.println(isAnagram("anagram", "nagaram"));

    }

}
