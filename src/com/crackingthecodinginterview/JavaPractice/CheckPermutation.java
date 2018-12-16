package com.crackingthecodinginterview.JavaPractice;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        Map<Integer, Character> map = new HashMap<Integer, Character>();
        for (int i = 0; i < s.length(); i++) {
            map.put(i, s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsValue(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(permutation("slient", "listen"));

    }

}
