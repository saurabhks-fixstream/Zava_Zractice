package com.leetcode.JavaPractice;

import java.util.HashMap;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int n = 65;
        int number = 0;
        for (int i = 1; i <= 26; i++) {
            map.put((char) n++, i);
        }
        n = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            number += Math.pow(26, n++) * map.get(s.charAt(i));
        }
        return number;
    }

    public static void main(String[] args) {

        System.out.println(titleToNumber("AA"));

    }

}
