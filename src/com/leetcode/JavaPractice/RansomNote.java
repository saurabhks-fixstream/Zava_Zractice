package com.leetcode.JavaPractice;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            if (!map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), 1);
            } else {
                map.put(magazine.charAt(i), (map.get(magazine.charAt(i)) + 1));
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i)) || map.get(ransomNote.charAt(i)) == 0) {
                return false;
            } else {
                map.put(ransomNote.charAt(i), (map.get(ransomNote.charAt(i)) - 1));
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));

    }

}
