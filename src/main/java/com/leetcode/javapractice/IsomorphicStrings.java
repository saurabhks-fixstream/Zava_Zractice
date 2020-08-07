package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            smap.put(s.charAt(i), i);
        }
        for (int i = 0; i < t.length(); i++) {
            tmap.put(t.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            int skey = smap.get(s.charAt(i));
            int tkey = tmap.get(t.charAt(i));
            if (skey != tkey) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isIsomorphic("aba", "baa"));
    }
}
