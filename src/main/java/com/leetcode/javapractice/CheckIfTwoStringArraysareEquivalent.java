package com.leetcode.javapractice;

public class CheckIfTwoStringArraysareEquivalent {

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null || word2 == null || word1.length == 0 | word2.length == 0) {
            return false;
        }
        return getString(word1).equals(getString(word2));
    }

    private static String getString(String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
