package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {

    private static boolean isAnagram(String s, String p) {
        if (p.length() == 0) {
            return true;
        }
        if (s.length() != p.length()) {
            return false;
        }
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            dict[p.charAt(i) - 'a']--;
            if (dict[p.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return list;
        }
        if (s.length() == 0 && p.length() == 0) {
            list.add(0);
            return list;
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String str = s.substring(i, i + p.length());
            if (isAnagram(str, p)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);

    }

}
