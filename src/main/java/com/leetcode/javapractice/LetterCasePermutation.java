package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        if (S == null || S.length() == 0) {
            return result;
        }
        lCPHelper(S.toCharArray(), 0, result);
        return result;
    }

    private static void lCPHelper(char[] c, int index, List<String> result) {
        if (c.length == index) {
            result.add(new String(c));
            return;
        }
        if (Character.isDigit(c[index])) {
            lCPHelper(c, index + 1, result);
        } else {
            c[index] = Character.toUpperCase(c[index]);
            lCPHelper(c, index + 1, result);
            c[index] = Character.toLowerCase(c[index]);
            lCPHelper(c, index + 1, result);
        }
    }

    public static void main(String[] args) {

        System.out.println(letterCasePermutation("a1b2"));
    }
}
