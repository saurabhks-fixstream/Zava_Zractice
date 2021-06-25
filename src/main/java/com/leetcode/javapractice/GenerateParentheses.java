package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateParenthesisHelper(list, "", 0, 0, n);
        return list;
    }

    public static void generateParenthesisHelper(
            List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            generateParenthesisHelper(list, str + "(", open + 1, close, max);
        }
        if (close < open) {
            generateParenthesisHelper(list, str + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }
}
