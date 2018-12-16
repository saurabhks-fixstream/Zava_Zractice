package com.leetcode.JavaPractice;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> smap = new HashMap<Character, Integer>();
        Map<Character, Integer> tmap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!smap.containsKey(s.charAt(i))) {
                smap.put(s.charAt(i), i);
            } else {
                smap.put(s.charAt(i), smap.get(s.charAt(i)));
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (!tmap.containsKey(t.charAt(i))) {
                tmap.put(t.charAt(i), i);
            } else {
                tmap.put(t.charAt(i), tmap.get(t.charAt(i)));
            }
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
