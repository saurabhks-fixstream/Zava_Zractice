package com.leetcode.javapractice;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> list = new LinkedList<String>();
        if (digits.length() == 0 || digits == null) {
            return list;
        }
        if (digits.contains("1") || digits.contains("0")) {
            return list;
        }
        String[] strings = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int index = digits.charAt(i) - '0' - 2;
            while (list.peek().length() == i) {
                String t = list.remove();
                for (char c : strings[index].toCharArray()) {
                    list.add(t + c);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println(list);

    }

}
