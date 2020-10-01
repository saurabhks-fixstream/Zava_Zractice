package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.List;

public class ValidWordSquare {

    public static boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                if (j >= words.size()
                        || words.get(j).length() <= i
                        || words.get(j).charAt(i) != words.get(i).charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        List<String> words = Arrays.asList("abcd", "bnrt", "crmy", "dtye");
        System.out.println(validWordSquare(words));
    }
}
