package com.leetcode.javapractice;

public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        char[] wordarray = word.toCharArray();
        int count = 0;
        for (char c : wordarray) {
            if (c == Character.toUpperCase(c)) {
                count++;
            }
        }
        if (count == 0
                || count == wordarray.length
                || count == 1 && wordarray[0] == Character.toUpperCase(wordarray[0])) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("google"));
        System.out.println(detectCapitalUse("GOOGLE"));
        System.out.println(detectCapitalUse("GooGle"));
    }
}
