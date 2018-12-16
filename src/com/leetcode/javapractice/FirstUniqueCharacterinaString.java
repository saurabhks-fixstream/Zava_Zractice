package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), (map.get(s.charAt(i)) + 1));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        System.out.println(firstUniqChar("geeksforgeeks"));

    }

}
