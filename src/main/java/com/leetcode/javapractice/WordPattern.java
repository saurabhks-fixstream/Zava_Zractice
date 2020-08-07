package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern(String pattern, String str) {
        if (pattern.length() == 0 || str.length() == 0) {
            return false;
        }
        boolean flag = true;
        List<String> list = new ArrayList<String>();
        Map<Character, String> map = new HashMap<Character, String>();
        StringBuilder sb = new StringBuilder();
        str += " ";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                sb.append(str.charAt(i));
            } else {
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        if (pattern.length() != list.size()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                if (!map.containsValue(list.get(i))) {
                    map.put(pattern.charAt(i), list.get(i));
                } else {
                    map.put(pattern.charAt(i), null);
                }
            }
        }
        for (int i = 0; i < pattern.length(); i++) {
            String temp = map.get(pattern.charAt(i));
            if (temp == null) {
                flag = false;
            } else if (!temp.equals(list.get(i))) {
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
    }
}
