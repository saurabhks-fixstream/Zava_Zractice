package com.leetcode.JavaPractice;

import java.util.ArrayList;

public class KeyboardRow {

    public static String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        ArrayList<String> rwords = new ArrayList<String>();
        for (String s : words) {
            int r1 = 0, r2 = 0, r3 = 0;
            String s1 = s.toLowerCase();
            int length = s1.length();
            for (int i = 0; i < length; i++) {
                if (row1.indexOf(s1.charAt(i)) >= 0) {
                    r1++;
                } else if (row2.indexOf(s1.charAt(i)) >= 0) {
                    r2++;
                } else if (row3.indexOf(s1.charAt(i)) >= 0) {
                    r3++;
                }
            }
            if (r1 == length) {
                rwords.add(s);
            } else if (r2 == length) {
                rwords.add(s);
            } else if (r3 == length) {
                rwords.add(s);
            }
        }
        return rwords.toArray(new String[rwords.size()]);
    }

    public static void main(String[] args) {

        String[] words = { "Hello", "Alaska", "Dad", "Peace" };
        for (String s : findWords(words)) {
            System.out.println(s);
        }

    }

}
